package archiver.app.domain.form

import java.nio.file.attribute.PosixFilePermission

import javax.validation.constraints.Size
import org.springframework.web.multipart.MultipartFile

import scala.beans.BeanProperty

class FileForm {

  @BeanProperty
  var id: java.lang.Long = _

  @Size(max = 60)
  @BeanProperty
  var fileName: String = _

  @BeanProperty
  var filePath: String = _

  @BeanProperty
  var selectedFilePermissions: Array[PosixFilePermission] = _

  @BeanProperty
  var categoryId: java.lang.Long = _

  @BeanProperty
  var multipartFile: MultipartFile = _

}
