package me.astynax.adventofcode2017

import Day03._

import org.scalatest.funsuite.AnyFunSuiteLike

class Day03Test extends AnyFunSuiteLike {
  test("step1 on examples") {
    assert(step1(1024) == 31)
    assert(step1(12) == 3)
    assert(step1(15) == 2)
  }

  test("step1 on input") {
    assert(step1(input) == 480)
  }

  test("Spiral walking") {
    val steps = fullTurn(Pos(1, 1), 2)
    assert(steps.size == 16)
    assert(steps.last == Pos(2, 2))
  }

  test("step2 on examples") {
    assert(step2(122) == 133)
    assert(step2(800) == 806)
  }

  test("step2 on input") {
    assert(step2(input) == 349975)
  }
}
