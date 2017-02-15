package services.database

import akka.actor.ActorSystem
import com.google.inject.Inject
import models.Room
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.driver.JdbcProfile
import slick.driver.PostgresDriver.api._

import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits.defaultContext

/**
  * Created by orkun on 10/02/17.
  */
class DatabaseController @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, val system: ActorSystem) extends  HasDatabaseConfigProvider[JdbcProfile]
                                                                                                                    with DatabaseTrait with SlickDatabaseMapping {

  /**
    * Room related methods
    * */

  override def insertRoom(room: Room) : Future[Unit] = db.run(RoomTable += room).map(_ => ())
  override def getRoom(id: Int) : Future[Option[Room]] = db.run(RoomTable.filter(_.roomID === id).result.headOption)

}
