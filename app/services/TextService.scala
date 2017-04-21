package services

import javax.inject.Singleton

import play.api.Logger

import scala.async.Async.async
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.Future._

trait TextService {
  def transformContent(text: String): Future[ResultText]
}

@Singleton
class WaitingTextService extends TextService {
  private lazy val logger = Logger(this.getClass)

  private val twoSeconds = 2000L
  private val threeSeconds = 3000L

  def transformContent(text: String) : Future[ResultText] = {
    logger.info("This will take three seconds for all async work to finish.")

    val reverseText = async {
      Thread.sleep(twoSeconds) // simulating long taking call
      text.reverse
    }

    val doubleText = async {
      Thread.sleep(threeSeconds) // simulating long taking call
      text + text
    }
    sequence(Seq(doubleText, reverseText)).map(list => ResultText(list))
  }
}
