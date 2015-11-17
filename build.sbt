name := "Flink streaming test1"

version := "0.0.1"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.apache.flink" % "flink-streaming-scala" % "0.10.0"
)

assemblyJarName in assembly := "flink-wordcount-streaming.jar"

mainClass in assembly := Some("Main")
