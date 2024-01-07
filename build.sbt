version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.12"

name := "AdventOfCode2017"

idePackagePrefix := Some("me.astynax.adventofcode2017")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test

val moveInputFile = taskKey[Unit]("Move input files (if any) into the resources dir")

moveInputFile := {
  import java.nio.file.{Files, StandardCopyOption}

  val target = (Compile / resourceDirectory).value
  val sources = (Path.userHome / "Downloads").glob("*.input")
  sources.get().foreach { file =>
    println("Moving " + file.name + "...")
    Files.move(file.toPath, (target / file.name).toPath, StandardCopyOption.ATOMIC_MOVE)
  }
}
