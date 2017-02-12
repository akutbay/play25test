package services

import play.api.libs.json.{Format, Json}

case class Text(content: String)

object Text {
  implicit val format: Format[Text] = Json.format[Text]
}

