package me.astynax.adventofcode2017

import fastparse._, NoWhitespace._

object Day09 {
  type Input = Thing

  sealed trait Thing

  case class Garbage(size: Int) extends Thing

  case class Group(things: List[Thing]) extends Thing

  def step1(input: Input): Int = scoreGroups(input)

  def step2(input: Input): Int = countGarbage(input)

  def scoreGroups(thing: Thing, level: Int = 1): Int = thing match {
    case _ : Garbage => 0
    case g : Group => level + g.things.map(scoreGroups(_, level + 1)).sum
  }

  def countGarbage(input: Input): Int = input match {
    case Garbage(x) => x
    case Group(ts) => ts.map(countGarbage).sum
  }

  private def parseThing[$: P]: P[Thing] = P(parseGroup | parseGarbage)

  private def parseGroup[$: P]: P[Group] = P("{" ~/ parseThing.rep(sep=",") ~ "}")
    .map { ts => Group(ts.toList) }

  private def parseGarbage[$: P]: P[Thing] = P("<" ~/ P(
    ("!" ~/ AnyChar).map(_ => 0) | CharPred(_ != '>').map(_ => 1)
  ).rep ~ ">")
    .map(xs => Garbage(xs.sum))

  def decode(line: String): Thing = parse(line, parseThing(_)).get.value

  lazy val input: Input = decode(Input.linesFrom("Day09.input").head)
}
