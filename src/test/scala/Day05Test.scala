package me.astynax.adventofcode2017

import Day05._

import org.scalatest.funsuite.AnyFunSuiteLike

class Day05Test extends AnyFunSuiteLike {
  test("input decoding") {
    assert(input.nonEmpty)
  }

  test("step1 on example") {
    assert(step1(List(0, 3, 0, 1, -3)) == 5)
  }

  test("step1 on input") {
    assert(step1(input) == 325922)
  }

  test("step2 on example") {
    assert(step2(List(0, 3, 0, 1, -3)) == 10)
  }

  test("step2 on input") {
    assert(step2(input) == 24490906)
  }
}
