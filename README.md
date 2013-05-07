play-2.1.1-scala-reactive-mongo-0.9-todo-list
=============================================

Play 2.1.1 scala reactive mongo 0.9 ToDo list sample application

1.

[tomas@tomasus mongodb]$ play new todolist
       _            _
 _ __ | | __ _ _  _| |
| '_ \| |/ _' | || |_|
|  __/|_|\____|\__ (_)
|_|            |__/

play! 2.1.1 (using Java 1.7.0_03 and Scala 2.10.0), http://www.playframework.org

The new application will be created in /home/tomas/playProj/mongodb/todolist

What is the application name? [todolist]
> 

Which template do you want to use for this new application? 

  1             - Create a simple Scala application
  2             - Create a simple Java application

> 1
OK, application todolist is created.

Have fun!

[tomas@tomasus mongodb]$ 


2.

//add play.plugins to conf

3.

[tomas@tomasus mongodb]$ cd todolist/
[tomas@tomasus todolist]$ play
[info] Loading global plugins from /home/tomas/.sbt/plugins
[info] Loading project definition from /home/tomas/playProj/mongodb/todolist/project
[info] Set current project to todolist (in build file:/home/tomas/playProj/mongodb/todolist/)
       _            _
 _ __ | | __ _ _  _| |
| '_ \| |/ _' | || |_|
|  __/|_|\____|\__ (_)
|_|            |__/

play! 2.1.1 (using Java 1.7.0_03 and Scala 2.10.0), http://www.playframework.org

> Type "help play" or "license" for more information.
> Type "exit" or use Ctrl+D to leave this console.

[todolist] $ 

4.

configure dependencies in Build.scala

5.

configure mongoDB in application.conf
# ReactiveMongo Plugin Config
mongodb.servers = ["localhost:27017"]
mongodb.db = "todolist"

6.

[todolist] $ clean
[success] Total time: 0 s, completed May 6, 2013 10:19:55 AM
[todolist] $ update
[info] Updating {file:/home/tomas/playProj/mongodb/todolist/}todolist...
[info] Done updating.                                                        
[success] Total time: 2 s, completed May 6, 2013 10:19:59 AM
[todolist] $ run

--- (Running the application from SBT, auto-reloading is enabled) ---

[info] play - Listening for HTTP on /0:0:0:0:0:0:0:0:9000

(Server started, use Ctrl+D to stop and go back to the console...)

7. Add routes

# Tasks          
GET     /tasks                  	controllers.Application.tasks
POST    /tasks                  	controllers.Application.newTask
POST    /tasks/:id/delete       	controllers.Application.deleteTask(id: Long)

8.

