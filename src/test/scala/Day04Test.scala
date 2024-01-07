package me.astynax.adventofcode2017

import Day04._

import org.scalatest.funsuite.AnyFunSuiteLike

class Day04Test extends AnyFunSuiteLike {
  test("input decoding") {
    assert(input.nonEmpty)
    assert(input.head.nonEmpty)
  }

  test("step1 on input") {
    assert(step1(input) == 466)
  }

  test("step2 on input") {
    assert(step2(input) == 251)
  }
}
