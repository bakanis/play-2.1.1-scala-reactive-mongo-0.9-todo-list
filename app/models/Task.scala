package models

import reactivemongo.bson._
import play.api.data.Forms._
import play.api.data._

case class Task(id: Option[BSONObjectID], label: String)

object Task {

  val taskForm = Form(
    mapping(
      "_id" -> ignored[Option[BSONObjectID]](None),
      "label" -> nonEmptyText)(Task.apply)(Task.unapply))

  implicit object TaskWriter extends BSONDocumentWriter[Task] {
    //toBSON
    def write(task: Task): BSONDocument = BSONDocument(
      "_id" -> task.id.getOrElse(BSONObjectID.generate),
      "label" -> BSONString(task.label))
  }

  implicit object TaskReader extends BSONDocumentReader[Task] {
    //fromBSON
    def read(doc: BSONDocument): Task = {
      Task(
        doc.getAs[BSONObjectID]("_id"),
        doc.getAs[BSONString]("label").get.value)
    }
  }
}
