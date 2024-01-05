package me.astynax.adventofcode2017

object Day02 {
  type Input = List[List[Int]]

  def step1(input: Input): Int = input.map { row => row.max - row.min }.sum

  def step2(input: Input): Int = (for {
    row <- input
    List(a, b) <- row.combinations(2)
    x = a max b
    y = a min b
    if scala.math.floorMod(x, y) == 0
  } yield x / y).sum

  def decode(lines: List[String]): Input = lines.map { line =>
    line.split(raw"\s+").map(_.toInt).toList
  }

  lazy val input: Input = decode(Input.linesFrom("Day02.input"))
}
