package services.database

import models._
import play.api.db.slick.HasDatabaseConfigProvider
import slick.lifted.{TableQuery, Tag}
import slick.driver.JdbcProfile
import slick.driver.PostgresDriver.api._

/**
  * Created by orkun on 10/02/17.
  */
trait SlickDatabaseMapping { self: HasDatabaseConfigProvider[JdbcProfile] =>

  val RoomTable = TableQuery[RoomTable]

  class RoomTable(tag: Tag) extends Table[Room](tag, "rooms") {

    def roomID = column[Int]("room_id", O.PrimaryKey, O.AutoInc)
    def roomName = column[String]("roomName")
    def password = column[String]("password")

    override def * = (roomID.?, password) <> (Room.tupled, Room.unapply)
  }

  val CharacterTable = TableQuery[CharacterTable]

  class CharacterTable(tag: Tag) extends Table[Character](tag, "characters") {

    def roomID = column[Int]("room_id")
    def roomID_FK = foreignKey("roomId", roomID, RoomTable)(_.roomID, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
    def character = column[String]("character")

    override def * = (roomID, character) <> (Character.tupled, Character.unapply)
  }
}