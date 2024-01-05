package me.astynax.adventofcode2017

import Day02._

import org.scalatest.funsuite.AnyFunSuiteLike

import scala.jdk.StreamConverters.StreamHasToScala

class Day02Test extends AnyFunSuiteLike {
  test("Input decoding") {
    assert(input.nonEmpty)
  }

  test("step1 on example") {
    assert(step1(decode(
      """5 9 2 8
        |9 4 7 3
        |3 8 6 5
        |""".stripMargin.lines().toScala(List)
    )) == 18)
  }

  test("step1 on input") {
    assert(step1(input) == 53460)
  }

  test("step2 on example") {
    assert(step2(decode(
      """5 9 2 8
        |9 4 7 3
        |3 8 6 5
        |""".stripMargin.lines().toScala(List))
    ) == 9)
  }

  test("step2 on input") {
    assert(step2(input) == 282)
  }
}
