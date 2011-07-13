// set the name of the project
name := "Date.scala"

version := "0.9"

organization := ""

// add a test dependency on ScalaCheck
libraryDependencies += "org.scala-tools.testing" %% "scalacheck" % "1.8" % "test"

// append -deprecation to the options passed to the Scala compiler
scalacOptions += "-deprecation"

// set the Scala version used for the project
//scalaVersion := "2.9.0.1"

mainClass := Some("date.scala.Date")

