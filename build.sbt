// set the name of the project
name := "datescala"

version := "0.9"

crossScalaVersions := Seq("2.8.1", "2.9.1", "2.9.2", "2.10.2", "2.10.3")

organization := "org.bitbucket.gabysbrain"

licenses := Seq("BSD-style" -> url("http://www.opensource.org/licenses/bsd-license.php"))

homepage := Some(url("https://github.com/gabysbrain/date.scala"))

// add a test dependency on ScalaCheck
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
    <url>git@github.com:gabysbrain/date.scala.git</url>
    <connection>scm:git:git@github.com:gabysbrain/date.scala.git</connection>
    <developerConnection>scm:git:git@github.com:gabysbrain/date.scala.git</developerConnection>
  </scm>
  <developers>
    <developer>
      <id>torsneyt</id>
      <name>Thomas Torsney-Weir</name>
      <url>http://www.tomtorsneyweir.com</url>
    </developer>
  </developers>)

mainClass := Some("date.scala.Date")

useGpg := true

