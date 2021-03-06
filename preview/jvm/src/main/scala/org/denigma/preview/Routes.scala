package org.denigma.preview

import akka.http.extensions.pjax.PJax
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import org.denigma.preview.templates.MyStyles
import play.twirl.api.Html

import akka.http.extensions.pjax.PJax
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives
import play.twirl.api.Html
import scalacss.Defaults._


/**
 * Trait that countains routes and handlers
 */
trait Routes extends  PJax{

  lazy val webjarsPrefix = "lib"

  lazy val resourcePrefix = "resources"

  def index =  pathSingleSlash{ctx=>
    ctx.complete {
      HttpResponse(  entity = HttpEntity(MediaTypes.`text/html`, html.index(None).body  ))
    }
  }

  def mystyles =    path("styles" / "mystyles.css"){
    complete  {
      HttpResponse(  entity = HttpEntity(MediaTypes.`text/css`,  MyStyles.render   ))   }
  }

  def loadResources = pathPrefix(resourcePrefix~Slash) {
    getFromResourceDirectory("")
  }

  def webjars =pathPrefix(webjarsPrefix ~ Slash)  {  getFromResourceDirectory(webjarsPrefix)  }

  def routes = index ~  webjars ~ mystyles ~ loadResources
}
