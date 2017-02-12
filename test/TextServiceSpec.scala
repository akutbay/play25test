import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.play.PlaySpec
import services.{ResultText, WaitingTextService}

import scala.concurrent.duration._

class TextServiceSpec extends PlaySpec with ScalaFutures {

  override implicit val patienceConfig = PatienceConfig(
    timeout = scaled(4000 millis),
    interval = scaled(100 millis)
  )

  "WaitingTextService" should {
    "produce correct output" in {

      whenReady(new WaitingTextService().transformContent("Example")) {
        result => assert(result == ResultText(Seq("ExampleExample", "elpmaxE")))
      }
    }
  }
}
