organization := "org.chuanframework"

name := "chuan"

version := "0.0"

scalaVersion := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= {
  val akkaV = "2.2.3"
  val sprayV = "1.2.0"
  Seq(
    "io.spray"            %   "spray-can"     % sprayV withSources(),
    "io.spray"            %   "spray-routing" % sprayV withSources(),
    "io.spray"            %   "spray-testkit" % sprayV withSources(),
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV withSources(),
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV withSources(),
    "org.specs2"          %%  "specs2"        % "2.2.3" % "test"
  )
}

seq(Revolver.settings: _*)
