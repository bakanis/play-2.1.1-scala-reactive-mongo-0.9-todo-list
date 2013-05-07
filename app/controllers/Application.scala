package controllers

import models._
import play.api._
import play.api.mvc._
import play.api.Play.current
import play.api.data._
import play.api.data.Forms._
import play.modules.reactivemongo._
import reactivemongo.bson._
import reactivemongo.api.collections.default.BSONCollection
import reactivemongo.core.commands.GetLastError
import scala.util.{ Failure, Success }
import scala.util.Try

object Application extends Controller with MongoController {

  override val db = ReactiveMongoPlugin.db
  lazy val collection = db[BSONCollection]("tasks")

  def index = Action {
    Redirect(routes.Application.tasks)
  }

  def tasks = Action { implicit request =>
    import Task.TaskReader
    val taskForm = Task.taskForm
    Async {
      println("tasks action " + request.body)
      val found = collection.find(BSONDocument()).cursor[Task]
      found.toList.map {
        tasks => Ok(views.html.index(tasks, taskForm))
      }
    }
  }

  def newTask = Action { implicit request =>
    import Task.TaskWriter
    val taskForm = Task.taskForm
    println("new task " + request.body)
    val found = collection.find(BSONDocument()).cursor
    //val tasks = found.toList[Task]
    taskForm.bindFromRequest.fold(
      //errors => BadRequest(views.html.index(tasks, errors)),
      errors => Redirect(routes.Application.tasks),
      task => {
        val id = BSONObjectID.generate
        collection.insert(new Task(Option(id), task.label))
        Redirect(routes.Application.tasks)
      })
  }

  def deleteTask(id: String) = Action { implicit request =>
    println("delete task" + request.body)
    val maybeOID: Try[BSONObjectID] = BSONObjectID.parse(id)
    println(maybeOID)
    //if OID is valid
    if (maybeOID.isSuccess) {
      val query = BSONDocument("_id" -> BSONObjectID(id))
      val futureRemove = collection.remove(query, GetLastError(), false)
      futureRemove.onComplete {
        case Failure(e) => throw e
        case Success(lasterror) => {
          println("successfully removed document")
        }
      }
    }else{
      Logger.warn("OOPS! Incorect ID: " + maybeOID)
    }
    Redirect(routes.Application.tasks)
  }
}