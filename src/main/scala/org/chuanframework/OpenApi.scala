package org.chuanframework

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

class OpenApiActor extends Actor with OpenApi {

  def actorRefFactory = context
  def receive = runRoute(apiRoutes)

}

trait OpenApi extends HttpService {

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