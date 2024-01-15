package me.astynax.adventofcode2017

import Day07._

import org.scalatest.funsuite.AnyFunSuiteLike

import scala.jdk.StreamConverters.StreamHasToScala

class Day07Test extends AnyFunSuiteLike {
  private lazy val example = decode(
    """pbga (66)
      |xhth (57)
      |ebii (61)
      |havc (66)
      |ktlj (57)
      |fwft (72) -> ktlj, cntj, xhth
      |qoyq (66)
      |padx (45) -> pbga, havc, qoyq
      |tknk (41) -> ugml, padx, fwft
      |jptl (61)
      |ugml (68) -> gyxo, ebii, jptl
      |gyxo (61)
      |cntj (57)
      |""".stripMargin.lines().toScala(List)
  )

  test("input decoding") {
    assert(input.nonEmpty)
    assert(example(Name("padx")) == (45, List(
      Name("pbga"), Name("havc"), Name("qoyq"),
    )))
  }

  test("tree building") {
    assert(bases(example)(Name("havc")) contains Name("padx"))
  }

  test("step1 on example") {
    assert(step1(example) == Name("tknk"))
  }

  test("step1 on input") {
    assert(step1(input) == Name("dgoocsw"))
  }

  test("step2 on example") {
    assert(step2(example) == 60)
  }

  test("step2 on input") {
    assert(step2(input) == 1275)
  }
}
