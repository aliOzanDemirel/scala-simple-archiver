package archiver.app.domain

import java.time.LocalDate

import com.fasterxml.jackson.annotation.{JsonIgnore, JsonIgnoreProperties}
import javax.persistence._
import javax.validation.constraints.Size
import org.springframework.format.annotation.DateTimeFormat

import scala.beans.BeanProperty

@Entity
@Table(name = "categories")
@JsonIgnoreProperties(ignoreUnknown = true, value = Array("hibernateLazyInitializer", "handler"))
class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _

  @Size(max = 60)
  @BeanProperty
  var categoryName: String = _

  @Size(max = 255)
  @BeanProperty
  var categoryDescription: String = _

//  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @BeanProperty
  var approvalDate: LocalDate = _

  @JsonIgnore
  @OneToMany(mappedBy = "category", cascade = Array(CascadeType.ALL), orphanRemoval = true)
  var files: java.util.Set[File] = new java.util.HashSet[File]

}
