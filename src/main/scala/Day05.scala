package me.astynax.adventofcode2017

import scala.annotation.tailrec

object Day05 {
  type Input = List[Int]

  def step1(input: Input): Int = runWith(input)(_ + 1)

  def step2(input: Input): Int = runWith(input) { x =>
    if (x >= 3) x - 1 else x + 1
  }

  private def runWith(input: Input)(mod: Int => Int): Int = compute(
    memory = input.zipWithIndex.map(_.swap).toMap,
    pc = 0,
    steps = 0,
    mod = mod,
  )

  @tailrec
  private def compute(memory: Map[Int, Int], pc: Int, steps: Int, mod: Int => Int): Int = {
    if (!memory.contains(pc)) steps
    else {
      val currentValue = memory(pc)
      compute(
        memory = memory.updated(pc, mod(currentValue)),
        pc = pc + currentValue,
        steps = steps + 1,
        mod = mod,
      )
    }
  }

  lazy val input: Input = Input.linesFrom("Day05.input").map(_.toInt)
}
