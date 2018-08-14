package archiver.app.domain

import java.time.LocalDateTime

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence._
import org.springframework.security.core.GrantedAuthority

import scala.beans.BeanProperty

//@Entity
//@Table(name = "users")
//@JsonIgnoreProperties(ignoreUnknown = true, value = Array("hibernateLazyInitializer", "handler"))
class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  var username: String = _

  @BeanProperty
  var password: String = _

  @BeanProperty
  var roles: java.util.List[GrantedAuthority] = _

  @BeanProperty
  var historyCreated: LocalDateTime = _

}
