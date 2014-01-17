package org.chuanframework.cnfgapi

import akka.actor.Actor
import spray.routing._
import spray.http._
import spray.http.MediaTypes._
import spray.httpx.marshalling.ToResponseMarshallable.isMarshallable
import spray.routing.Directive.pimpApply

class CnfgApiActor extends Actor with CnfgApi {

  def actorRefFactory = context
  def receive = runRoute(apiRoutes)

}

trait CnfgApi extends HttpService {

  val apiRoutes =
    path("info") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Say hello to <i>spray-routing</i> on <i>spray-can</i>!</h1>
              </body>
            </html>
          }
        }
      }
    } ~
    path("hello") {
      get {
        respondWithMediaType(`application/json`) {
          complete {
            "world"
          }
        }
      }
    }

}