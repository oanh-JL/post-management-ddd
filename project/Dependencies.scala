import sbt._

object Dependencies {
  lazy val scalikejdbcVersion = "3.3.2"
  lazy val mysqlVersion = "8.0.15"

  val mysqlConnectorJava = "mysql" % "mysql-connector-java" % mysqlVersion

  val skinnyOrm = "org.skinny-framework" %% "skinny-orm" % "3.0.0"

  val scalikejdbc = "org.scalikejdbc" %% "scalikejdbc" % scalikejdbcVersion
  val scalikejdbcConfig = "org.scalikejdbc" %% "scalikejdbc-config" % scalikejdbcVersion
  val scalikejdbcTest = "org.scalikejdbc" %% "scalikejdbc-test" % scalikejdbcVersion % Test
  val scalikejdbcPlayAdapter = "org.scalikejdbc" %% "scalikejdbc-play-dbapi-adapter" % "2.7.0-scalikejdbc-3.3"
  val logBack = "ch.qos.logback" % "logback-classic" % "1.2.3"
  val jBcrypt = "org.mindrot" % "jbcrypt" % "0.4"

  val flywayDb = "org.flywaydb" %% "flyway-play" % "5.3.2"


  val persistenceDependencies = Seq(
    scalikejdbc,
    scalikejdbcConfig,
    scalikejdbcTest,
    scalikejdbcPlayAdapter,
    logBack,
    mysqlConnectorJava,
    skinnyOrm,
    flywayDb,
    jBcrypt
  )

}
