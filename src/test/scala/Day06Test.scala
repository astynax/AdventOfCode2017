package me.astynax.adventofcode2017

import Day06._

import org.scalatest.funsuite.AnyFunSuiteLike

class Day06Test extends AnyFunSuiteLike {
  test("input decoding") {
    assert(input.size == 16)
  }

  test("moving") {
    assert(move(decode("0 2 7 0"), 2) == decode("2 4 1 2"))
  }

  test("highest bank search") {
    assert(highest(decode("0 2 7 0")) == 2)
  }

  test("steps on example") {
    assert(steps(decode("0 2 7 0")) == (5, 4))
  }

  test("steps on input") {
    assert(steps(input) == (14029, 2765))
  }
}
