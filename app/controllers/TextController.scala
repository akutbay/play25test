package controllers

import javax.inject.{Inject, Singleton}

import play.api.libs.json._
import play.api.mvc.{Action, BodyParsers, Controller}
import services.{Text, TextService}
import services.ResultText.format
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class TextController @Inject()(textService: TextService) extends Controller {

  def test(): Action[JsValue] = Action.async(BodyParsers.parse.json) {
    request => {
      request.body.validate[Text] match {
        case JsSuccess(text, _) => textService.transformContent(text.content).map(result => Ok(Json.toJson(result)))
        case JsError(_) => Future(BadRequest("error"))
      }
    }
  }
}

