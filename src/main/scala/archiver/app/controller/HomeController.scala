package archiver.app.controller

import java.security.Principal

import archiver.app.common.{Mappings, Utils}
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{GetMapping, PathVariable}
import org.springframework.web.util.UriUtils

@Controller
class HomeController {

  @GetMapping(Array("/"))
  def homePage(principal: Principal, model: Model): String = {
    if (principal != null) {
      Mappings.REDIRECT_TO_FILES
    } else {
      "index"
    }
  }

  @GetMapping(Array("/alert/type/{alertType}/message/{error}"))
  def alertFragment(model: Model, @PathVariable alertType: String, @PathVariable error: String): String = {

    model.addAttribute("alertType", alertType)
    model.addAttribute("errorMessage", UriUtils.decode(error, "UTF-8"))

    "common/alert :: alert (type=${alertType}, message=${errorMessage})"
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping(Array("/admin")) def showAdmin(model: Model): String = {

    model.addAttribute("allUsers", null)

    Utils.decorateMainPage(model, "admin/list-users", "users")
  }

}
