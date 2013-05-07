
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Task],Form[models.Task],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(tasks: List[Task], taskForm: Form[models.Task]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.50*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Todo list")/*5.19*/ {_display_(Seq[Any](format.raw/*5.21*/("""
    
    <h1>"""),_display_(Seq[Any](/*7.10*/tasks/*7.15*/.size)),format.raw/*7.20*/(""" task(s)</h1>
    
    <ul>
        """),_display_(Seq[Any](/*10.10*/tasks/*10.15*/.map/*10.19*/ { task =>_display_(Seq[Any](format.raw/*10.29*/("""
            <li>
                <a href=""""),_display_(Seq[Any](/*12.27*/routes/*12.33*/.Application.deleteTask(task.id.get.stringify))),format.raw/*12.79*/("""">"""),_display_(Seq[Any](/*12.82*/task/*12.86*/.label)),format.raw/*12.92*/("""</a>
                
                """),_display_(Seq[Any](/*14.18*/form(routes.Application.deleteTask(task.id.get.stringify))/*14.76*/ {_display_(Seq[Any](format.raw/*14.78*/("""
                    <input type="submit" value="Delete">
                """)))})),format.raw/*16.18*/("""
            </li>
        """)))})),format.raw/*18.10*/("""
    </ul>
    
    <h2>Add a new task</h2>
    
    """),_display_(Seq[Any](/*23.6*/form(routes.Application.newTask)/*23.38*/ {_display_(Seq[Any](format.raw/*23.40*/("""
        
        """),_display_(Seq[Any](/*25.10*/inputText(taskForm("label")))),format.raw/*25.38*/(""" 
        
        <input type="submit" value="Create">
        
    """)))})),format.raw/*29.6*/("""
    
""")))})))}
    }
    
    def render(tasks:List[Task],taskForm:Form[models.Task]): play.api.templates.Html = apply(tasks,taskForm)
    
    def f:((List[Task],Form[models.Task]) => play.api.templates.Html) = (tasks,taskForm) => apply(tasks,taskForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue May 07 01:48:48 EEST 2013
                    SOURCE: /home/tomas/playProj/mongodb/todolist/app/views/index.scala.html
                    HASH: afb13bbcddf1eb8a257fdb2f2120cdecece85cbf
                    MATRIX: 527->1|668->49|696->68|732->70|757->87|796->89|846->104|859->109|885->114|958->151|972->156|985->160|1033->170|1113->214|1128->220|1196->266|1235->269|1248->273|1276->279|1351->318|1418->376|1458->378|1565->453|1625->481|1714->535|1755->567|1795->569|1850->588|1900->616|2001->686
                    LINES: 19->1|23->1|25->4|26->5|26->5|26->5|28->7|28->7|28->7|31->10|31->10|31->10|31->10|33->12|33->12|33->12|33->12|33->12|33->12|35->14|35->14|35->14|37->16|39->18|44->23|44->23|44->23|46->25|46->25|50->29
                    -- GENERATED --
                */
            