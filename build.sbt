name := "simpleapi"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies ++= Seq(
  "com.twitter" % "finatra-http_2.12" % "20.4.1",
  "ch.qos.logback" % "logback-classic" % "1.3.0-alpha5"
)
