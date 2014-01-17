package org.chuanframework

import akka.actor.{ ActorSystem, Props }
import akka.io.IO
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import org.chuanframework.cnfgapi.CnfgApiActor
import org.chuanframework.openapi.OpenApiActor

object ChuanApp extends App {

  implicit val system = ActorSystem("chuan")

  val cnfgapi = system.actorOf(Props[CnfgApiActor], "cnfgapi")

  val openapi = system.actorOf(Props[OpenApiActor], "openapi")

  implicit val timeout = Timeout(5.seconds)

  IO(Http) ? Http.Bind(cnfgapi, interface = "0.0.0.0", port = 7979)

  IO(Http) ? Http.Bind(openapi, interface = "0.0.0.0", port = 8080)

}