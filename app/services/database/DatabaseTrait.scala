package services.database

import models.Room

import scala.concurrent.Future

/**
  * Created by orkun on 10/02/17.
  */
trait DatabaseTrait {

  def insertRoom(room: Room) : Future[Unit]
  def getRoom(id: Int) : Future[Option[Room]]

}
