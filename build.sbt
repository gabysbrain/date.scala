// set the name of the project
name := "datescala"

version := "0.9"

//scalaVersion := "2.8.1"
crossScalaVersions := Seq("2.8.0", "2.8.1", "2.9.1", "2.9.2")

organization := "org.bitbucket.gabysbrain"

licenses := Seq("BSD-style" -> url("http://www.opensource.org/licenses/bsd-license.php"))

homepage := Some(url("https://bitbucket.org/gabysbrain/date.scala"))

// add a test dependency on ScalaCheck
//libraryDependencies += "org.scala-tools.testing" %% "scalacheck" % "1.8" % "test"

//libraryDependencies <+= "org.scala-lang" % "scala-swing" % scalaVersion
//libraryDependencies <+= "org.scala-lang" % "scala-swing" % crossScalaVersionString
libraryDependencies <<= (scalaVersion, libraryDependencies) {(sv, deps) =>
  deps :+ ("org.scala-lang" % "scala-swing" % sv)
}

// append -deprecation to the options passed to the Scala compiler
scalacOptions += "-deprecation"

// Sonatype publishing settings
publishMavenStyle := true

publishTo <<= version { (v:String) =>
  val nexus = "https://oss.sonatype.org/"
  if(v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

// POM metadata
pomIncludeRepository := { _ => false }

pomExtra := (
  <scm>
    <url>git@bitbucket.org:gabysbrain/date.scala.git</url>
    <connection>scm:git:git@bitbucket.org:gabysbrain/date.scala.git</connection>
    <developerConnection>scm:git:git@bitbucket.org:gabysbrain/date.scala.git</developerConnection>
  </scm>
  <developers>
    <developer>
      <id>torsneyt</id>
      <name>Thomas Torsney-Weir</name>
      <url>http://www.tomtorsneyweir.com</url>
    </developer>
  </developers>)

mainClass := Some("date.scala.Date")

