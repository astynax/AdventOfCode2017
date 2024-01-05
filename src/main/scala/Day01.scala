package me.astynax.adventofcode2017

object Day01 {
  private type Input = List[Int]

  def step1(input: Input): Int = captcha(input)

  def step2(input: Input): Int = captcha(input, input.size / 2)

  private def captcha(digits: Input, offset: Int = 1): Int =
    digits.zip(digits.drop(offset) ++ digits.take(offset))
      .filter { case (a, b) => a == b }
      .map(_._1)
      .sum

  lazy val input: Input = Input.linesFrom("Day01.input").head.map(_.asDigit).toList
}
