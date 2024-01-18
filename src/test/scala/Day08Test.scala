package me.astynax.adventofcode2017

import Day08._

import org.scalatest.funsuite.AnyFunSuiteLike

class Day08Test extends AnyFunSuiteLike {
  test("decoding") {
    assert(decode(List("c dec -10 if a >= 1")) == List(
      Step(
        target = Register("c"),
        op = IncDec.Dec,
        amount = -10,
        ifRegister = Register("a"),
        comparison = Comparison.GtE,
        comparisonArgument = 1,
      )
    ))
  }

  test("input decoding") {
    assert(input.nonEmpty)
  }

  test("steps on input") {
    assert(steps(input) == (5946, 6026))
  }
}
