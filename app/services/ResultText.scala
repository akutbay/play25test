package services

import play.api.libs.json.{Format, Json}

case class ResultText(transformedValues: Seq[String])

object ResultText {
  implicit val format: Format[ResultText] = Json.format[ResultText]
}