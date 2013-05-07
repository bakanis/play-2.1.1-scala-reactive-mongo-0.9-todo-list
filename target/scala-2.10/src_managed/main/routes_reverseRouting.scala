// @SOURCE:/home/tomas/playProj/mongodb/todolist/conf/routes
// @HASH:723c1738affb4abb7dfbe256be7eec3790b142f9
// @DATE:Mon May 06 23:37:37 EEST 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._
import java.net.URLEncoder

import play.api.mvc._


import Router.queryString


// @LINE:16
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:13
def deleteTask(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "tasks/" + implicitly[PathBindable[String]].unbind("id", URLEncoder.encode(id, "utf-8")) + "/delete")
}
                                                

// @LINE:9
def tasks(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "tasks")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:10
def newTask(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "tasks")
}
                                                
    
}
                          

// @LINE:16
class ReverseAssets {
    

// @LINE:16
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:16
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:13
def deleteTask : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteTask",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/delete"})
      }
   """
)
                        

// @LINE:9
def tasks : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.tasks",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:10
def newTask : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.newTask",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks"})
      }
   """
)
                        
    
}
              

// @LINE:16
class ReverseAssets {
    

// @LINE:16
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:16
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {

// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:13
def deleteTask(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteTask(id), HandlerDef(this, "controllers.Application", "deleteTask", Seq(classOf[String]), "GET", """ original is post
POST    /tasks/:id/delete       	controllers.Application.deleteTask(id: String)""", _prefix + """tasks/$id<[^/]+>/delete""")
)
                      

// @LINE:9
def tasks(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.tasks(), HandlerDef(this, "controllers.Application", "tasks", Seq(), "GET", """ Tasks          """, _prefix + """tasks""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:10
def newTask(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.newTask(), HandlerDef(this, "controllers.Application", "newTask", Seq(), "POST", """""", _prefix + """tasks""")
)
                      
    
}
                          

// @LINE:16
class ReverseAssets {
    

// @LINE:16
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
                  
      