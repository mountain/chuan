package org.chuanframework.openapi

import akka.actor.Actor
import spray.routing._
import spray.http._
import spray.http.MediaTypes._
import spray.httpx.marshalling.ToResponseMarshallable.isMarshallable
import spray.routing.Directive.pimpApply

class OpenApiActor extends Actor with OpenApi {

  def actorRefFactory = context
  def receive = runRoute(apiRoutes)

}

trait OpenApi extends HttpService {

  val apiRoutes =
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