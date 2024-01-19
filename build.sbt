version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.12"

name := "AdventOfCode2017"

idePackagePrefix := Some("me.astynax.adventofcode2017")

libraryDependencies +=  "com.lihaoyi" %% "fastparse" % "3.0.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test

scalacOptions ++= Seq(
  "-Werror",
  "-deprecation",
  "-feature"
)

val moveInputFile = taskKey[Unit]("Move input files (if any) into the resources dir")

moveInputFile := {
  import java.nio.file.{Files, StandardCopyOption}
  import scala.sys.process.stringSeqToProcess

  val target = (Compile / resourceDirectory).value
  val sources = (Path.userHome / "Downloads").glob("*.input")
  sources.get().foreach { file =>
    println("Moving " + file.name + "...")
    val targetFile = target / file.name
    Files.move(file.toPath, targetFile.toPath, StandardCopyOption.ATOMIC_MOVE)
    Seq("git", "add", targetFile.toString).!!
  }
}
