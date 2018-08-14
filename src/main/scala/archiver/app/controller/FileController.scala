package archiver.app.controller

import java.nio.file.attribute.PosixFilePermission
import java.time.LocalDate

import archiver.app.common.Utils.errorMap
import archiver.app.common.{Mappings, Utils}
import archiver.app.domain.form.FileForm
import archiver.app.service.{CategoryService, FileService}
import javax.servlet.http.HttpServletRequest
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ByteArrayResource
import org.springframework.http._
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation._

@Controller
class FileController @Autowired()(private val fileService: FileService,
                                  private val categoryService: CategoryService) {

  val log: Logger = LoggerFactory.getLogger(classOf[FileController])

  @GetMapping(Array(Mappings.ALL_FILES))
  def listFiles(model: Model): String = {

    val files = fileService.getAllFiles
    log.debug(s"Retrieved ${files.size()} files from DB")

    model.addAttribute("files", files)
    Utils.decorateMainPage(model, "files/list-files", "list-files")
  }

  @GetMapping(Array(Mappings.FILE_FORM))
  def createOrEditFile(model: Model, @RequestParam(name = "id", required = false) id: java.lang.Long): String = {

    var file = new FileForm
    if (id == null) {
      log.debug("File record is being created")
    } else {

      file = Utils.fileEntityToFileForm(fileService.getFileById(id))

      if (file.id != 0) {
        log.debug(s"File '${file.fileName}' is found, will be used to populate form")

      } else {
        log.warn(s"File with ID: $id is tried to be edited but not found")
        return listFiles(model)
      }
    }

    model.addAttribute("allFilePermissions", PosixFilePermission.values())
    model.addAttribute("allCategories", categoryService.getAllCategories)
    model.addAttribute("file", file)

    Utils.decorateMainPage(model, "files/file-form", "file-form")
  }

  @PostMapping(Array(Mappings.SAVE_FILE))
  def saveFile(@ModelAttribute(name = "file") fileForm: FileForm, errors: BindingResult, model: Model): String = {
    log.debug(s"File with name ${fileForm.fileName} is being saved")

    val category = categoryService.getCategoryById(fileForm.categoryId)

    if (category == null) {
      return "error"
    }

    val isSuccessful: Boolean = fileService.saveFile(fileForm, category)

    if (isSuccessful) {
      Mappings.REDIRECT_TO_FILES
    } else {
      "error"
    }
  }

  @PostMapping(value = Array(Mappings.DELETE_FILE),
    consumes = Array(MediaType.APPLICATION_JSON_VALUE),
    produces = Array(MediaType.APPLICATION_JSON_VALUE))
  @ResponseBody
  def deleteFile(@RequestBody body: Map[java.lang.String, java.lang.Long]): ResponseEntity[Map[String, Object]] = {

    val fileId = body("id")
    log.debug(s"Request to ${Mappings.DELETE_FILE} to remove record with ID: $fileId")

    if (fileId == null) {
      ResponseEntity.badRequest()
        .body(Map("errorMessage" -> "ID of file is not found in request body!"))
        .asInstanceOf[ResponseEntity[Map[String, Object]]]
    } else {
      Utils.buildResponse(fileService.deleteFile(fileId))
    }
  }

  @GetMapping(Array(Mappings.DOWNLOAD_FILE))
  def downloadFile(@RequestParam(name = "id", required = true) id: java.lang.Long,
                   request: HttpServletRequest): ResponseEntity[Object] = {

    try {
      val resp = fileService.readFileToBytes(id)

      if (resp.status == HttpStatus.OK) {
        val fileToDownload = new ByteArrayResource(resp.result.asInstanceOf[Array[Byte]])

        ResponseEntity.ok()
          .contentLength(fileToDownload.contentLength)
          .contentType(MediaType.APPLICATION_OCTET_STREAM)
          .cacheControl(CacheControl.noCache())
          .header(HttpHeaders.CONTENT_DISPOSITION,
            s"attachment; filename='FILE_" + id + "_" + LocalDate.now() + "'")
          .body(fileToDownload)
      } else {
        Utils.errorResponse(resp.status, resp.errorMessage)
      }
    } catch {
      case ex: Exception =>
        log.error(s"Error occured while downloading file with ID: $id", ex)
        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMap(ex.getMessage))
    }
  }

}
