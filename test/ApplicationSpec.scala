import org.scalatestplus.play._
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test._
import services.Text

class ApplicationSpec extends PlaySpec with OneAppPerTest {

  "TextController" should {
    "return a correct resultObject" in {
      contentAsString(route(app, FakeRequest(POST, "/test").withJsonBody(Json.toJson(Text("beispielText")))).get) mustBe """{"transformedValues":["beispielTextbeispielText","txeTleipsieb"]}"""
    }
  }

}
