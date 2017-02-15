package controllers

import akka.actor.ActorSystem
import javax.inject._
import play.api.mvc._
import services.database.DatabaseController
import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.duration._


@Singleton
class AsyncController @Inject()(actorSystem: ActorSystem, databaseController: DatabaseController)(implicit exec: ExecutionContext) extends Controller {


  def index = Action.async {
    Future(Ok(""))
  }

  private def getFutureMessage(delayTime: FiniteDuration): Future[String] = {
    val promise: Promise[String] = Promise[String]()
    actorSystem.scheduler.scheduleOnce(delayTime) { promise.success("Hi!") }
    promise.future
  }

}
