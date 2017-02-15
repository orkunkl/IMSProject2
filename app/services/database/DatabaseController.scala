package services.database

import akka.actor.ActorSystem
import com.google.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.driver.JdbcProfile

import scala.concurrent.Future

/**
  * Created by orkun on 10/02/17.
  */
class DatabaseController @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, val system: ActorSystem) extends  HasDatabaseConfigProvider[JdbcProfile]
                                                                                                                    with DatabaseTrait with SlickDatabaseMapping {

  //def insertRoom(password: Seq[String]) : Future[Unit] = db.run(RoomTable += )
}
