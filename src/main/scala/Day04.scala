package me.astynax.adventofcode2017

object Day04 {
  type Input = List[List[String]]

  def step1(input: Input): Int = input.count { words =>
    words.size == words.distinct.size
  }

  def step2(input: Input): Int = step1(input.map(_.map { w => w.sorted }))

  def decode(lines: List[String]): Input = lines.map(_.split(raw"\s").toList)

  lazy val input: Input = decode(Input.linesFrom("Day04.input"))
}
