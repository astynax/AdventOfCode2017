package me.astynax.adventofcode2017

import Day01._

import org.scalatest.funsuite.AnyFunSuiteLike

class Day01Test extends AnyFunSuiteLike {
  test("Input loading") {
    assert(input.nonEmpty)
  }

  test("step1 on examples") {
    assert(step1(List(1, 1, 2, 2)) == 3)
    assert(step1(List(1, 1, 1, 1)) == 4)
    assert(step1(List(1, 2, 3, 4)) == 0)
    assert(step1(List(9, 1, 2, 1, 2, 1, 2, 9)) == 9)
  }

  test("step1 on input") {
    assert(step1(input) == 1029)
  }

  test("step2 on examples") {
    assert(step2(List(1, 2, 1, 2)) == 6)
    assert(step2(List(1, 2, 2, 1)) == 0)
    assert(step2(List(1, 2, 3, 4, 2, 5)) == 4)
    assert(step2(List(1, 2, 3, 1, 2, 3)) == 12)
    assert(step2(List(1, 2, 1, 3, 1, 4, 1, 5)) == 4)
  }

  test("step2 on input") {
    assert(step2(input) == 1220)
  }
}
