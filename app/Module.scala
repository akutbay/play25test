import com.google.inject.AbstractModule
import services.{TextService, WaitingTextService}

class Module extends AbstractModule {

  override def configure() = {
    bind(classOf[TextService]).to(classOf[WaitingTextService])
  }

}
