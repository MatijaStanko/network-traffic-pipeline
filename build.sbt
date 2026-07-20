import sbt.Keys.libraryDependencies

ThisBuild / scalaVersion := "2.13.18"

lazy val root = (project in file("."))
  .settings(
    name := "network-traffic-pipeline",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.20" % Test
  )

