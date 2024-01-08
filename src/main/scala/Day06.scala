package me.astynax.adventofcode2017

import scala.annotation.tailrec

object Day06 {
  private type Banks = Map[Int, Int]

  def steps(input: Banks): (Int, Int) = {
    @tailrec
    def go(seen: Map[Banks, Int], banks: Banks, step: Int): (Int, Int) = {
      seen.get(banks) match {
        case Some(last) => (step, step - last)
        case None => go(
          seen = seen.updated(banks, step),
          banks = move(banks, highest(banks)),
          step = step + 1,
        )
      }
    }

    go(Map.empty[Banks, Int], input, 0)
  }

  def highest(banks: Banks): Int = banks
    .keys.toList.sorted.map { k =>
      k -> banks(k)
    }.maxBy(_._2)._1

  def move(banks: Banks, from: Int): Banks = distribute(
    banks.updated(from, 0), banks(from), from + 1
  )

  @tailrec
  private def distribute(banks: Banks, blocks: Int, start: Int): Banks = {
    if (blocks == 0)
      banks
    else if (start >= banks.size)
      distribute(banks, blocks, 0)
    else distribute(
      banks = banks.updated(start, banks(start) + 1),
      blocks - 1,
      start + 1,
    )
  }

  lazy val input: Banks = decode(Input.linesFrom("Day06.input").head)

  def decode(line: String): Banks = (for {
    (part, idx) <- line.split(raw"\s+").zipWithIndex
  } yield idx -> part.toInt).toMap
}
