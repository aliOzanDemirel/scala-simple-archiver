package archiver.app.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence._
import javax.validation.constraints.{NotNull, Size}

import scala.beans.BeanProperty

@Entity
@Table(name = "files")
@JsonIgnoreProperties(ignoreUnknown = true, value = Array("hibernateLazyInitializer", "handler"))
class File {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _

  @Size(max = 60)
  @BeanProperty
  var fileName: String = _

  @NotNull
  @BeanProperty
  var savedPath: String = _

  // removed means the file does not exist where savedPath points
  @NotNull
  @BeanProperty
  var isRemoved: Boolean = false

  @BeanProperty
  var filePermissions: String = _

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "fk_category_id", nullable = false)
  @BeanProperty
  var category: Category = _

}
