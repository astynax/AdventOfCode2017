package me.astynax.adventofcode2017

import Day09._

import org.scalatest.funsuite.AnyFunSuiteLike

class Day09Test extends AnyFunSuiteLike {
  test("decoding") {
    assert(List(
      raw"<>",
      raw"<random characters>",
      raw"<<<<>",
      raw"<{!>}>",
      raw"<!!>",
      raw"<!!!>>",
      raw"""<{o"i!a,<{i<a>""",
    ).map(decode).forall(_.isInstanceOf[Garbage]))

    assert(List(
      raw"{}",
      raw"{{{}}}",
      raw"{{},{}}",
      raw"{{{},{},{{}}}}",
      raw"{<{},{},{{}}>}",
      raw"{<a>,<a>,<a>,<a>}",
      raw"{{<a>},{<a>},{<a>},{<a>}}",
      raw"{{<!>},{<!>},{<!>},{<a>}}",
    ).map(decode).forall(_.isInstanceOf[Group]))
  }

  test("input decoding") {
    assert(input.isInstanceOf[Group])
  }

  test("group scoring") {
    assert(scoreGroups(decode(raw"{}")) == 1)
    assert(scoreGroups(decode(raw"{{{}}}")) == 6)
    assert(scoreGroups(decode(raw"{{},{}}")) == 5)
    assert(scoreGroups(decode(raw"{{{},{},{{}}}}")) == 16)
    assert(scoreGroups(decode(raw"{<a>,<a>,<a>,<a>}")) == 1)
    assert(scoreGroups(decode(raw"{{<ab>},{<ab>},{<ab>},{<ab>}}")) == 9)
    assert(scoreGroups(decode(raw"{{<!!>},{<!!>},{<!!>},{<!!>}}")) == 9)
    assert(scoreGroups(decode(raw"{{<a!>},{<a!>},{<a!>},{<ab>}}")) == 3)
  }

  test("step1 on input") {
    assert(step1(input) == 13154)
  }

  test("garbage counting") {
    assert(countGarbage(decode(raw"""<{o"i!a,<{i<a>""")) == 10)
  }

  test("step2 on input") {
    assert(step2(input) == 6369)
  }
}
