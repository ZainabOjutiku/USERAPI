name := "simpleapi"

version := "0.1"

scalaVersion := "2.12.10"
lazy val versions = new {
  val swagger = "0.7.2"
  val scalaTest = "3.0.8"
  val specs2 = "2.4.17"
}
resolvers ++= Seq("Twitter repository" at "http://maven.twttr.com")

libraryDependencies ++= Seq(
  "com.twitter" % "finatra-http_2.12" % "20.4.1",
  "ch.qos.logback" % "logback-classic" % "1.3.0-alpha5",
  "com.twitter" %% "finatra-http" % "20.4.1" % "test" classifier "tests",
  "com.twitter" %% "finatra-jackson" % "20.4.1" % "test" classifier "tests",
  "com.twitter" %% "inject-server" % "20.4.1" % "test" classifier "tests",
  "com.twitter" %% "inject-app" % "20.4.1" % "test" classifier "tests",
  "com.twitter" %% "inject-core" % "20.4.1" % "test" classifier "tests",
  "com.twitter" %% "inject-modules" % "20.4.1" % "test" classifier "tests",
  "org.scalatest" %% "scalatest" % versions.scalaTest % Test,
  "org.specs2" %% "specs2-core" % versions.specs2 % Test,
//  "com.chiradip.rediscl" % "redisclient_2.10" % "0.8",
  "net.debasishg" %% "redisclient" % "3.30",
  "org.mockito" % "mockito-core" % "3.1.0" % Test
)
