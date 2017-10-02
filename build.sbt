
name := "PigUdfScala"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies := Seq(
  "org.apache.hadoop" % "hadoop-core" % "0.20.2" % "provided",
  "org.apache.pig" % "pig" % "0.15.0" % "provided",
  "org.scalactic" %% "scalactic" % "3.0.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
  //"org.scalatest" % "scalatest_2.12.0-M4" % "2.2.6"
)



    