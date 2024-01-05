package me.astynax.adventofcode2017

import scala.io.Source
import scala.util.Using

object Input {
  def linesFrom(name: String): List[String] =
    Using(Source.fromResource(name))(_.getLines().toList).get
}
