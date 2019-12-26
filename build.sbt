import Dependencies._
import Keys._

name := "bbs_ddd"
 
version := "1.0"

lazy val commonSettings = Seq(
  resolvers+= "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases",
  scalaVersion := "2.12.3",
  libraryDependencies ++= Seq(jdbc ,ehcache, ws, filters, specs2 % Test, guice,scalikejdbc,scalikejdbcPlayAdapter)
)

lazy val subProject = Seq(
  scalaSource in Compile := baseDirectory.value / "src" / "main" / "scala",
  scalaSource in Test := baseDirectory.value / "src" / "test" / "scala",
  resourceDirectory in Compile := baseDirectory.value / "src" / "main" / "resources",
  resourceDirectory in Test := baseDirectory.value / "src" / "test" / "resources"
)

lazy val root = (project in file("."))
  .aggregate(domain, port)
  .dependsOn(domain, port, application%"compile->compile", utility)
  .settings(commonSettings)
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)


lazy val domain = (project in file ("bbs/domain"))
  .settings(commonSettings)
  .settings(subProject)

lazy val application = (project in file("bbs/application"))
  .dependsOn(utility, domain)
  .settings(commonSettings)
  .settings(subProject)

lazy val portHttp = (project in file("bbs/port/primary/http"))
  .dependsOn(application%"compile->compile",portDatabase)
  .settings(commonSettings)
  .settings(subProject)
  .enablePlugins(PlayScala)
  .enablePlugins(FlywayPlugin)

lazy val portDatabase = (project in file("bbs/port/secondary/persistence"))
  .dependsOn(application%"compile->compile")
  .settings(commonSettings)
  .settings(subProject)
  .settings(libraryDependencies ++= persistenceDependencies)
  .enablePlugins(FlywayPlugin)
  .settings(
    flywayLocations := Seq("filesystem:bbs/port/secondary/database/src/main/resources/db.migration.default")
  )

lazy val port = (project in file("bbs/port"))
  .aggregate(portDatabase, portHttp)
  .dependsOn(portDatabase, portHttp)
  .settings(commonSettings)
  .settings(subProject)

lazy val utility = (project in file("bbs/utility"))
  .settings(commonSettings)
  .settings(subProject)