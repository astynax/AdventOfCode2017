package me.astynax.adventofcode2017

import scala.math.{abs, floorMod}

case class Pos(x: Int, y: Int) {
  def bounded(width: Int, height: Int): Pos = Pos(
    x = floorMod(x, width),
    y = floorMod(y, height)
  )

  def distanceTo(other: Pos): Int =
    abs(x - other.x) + abs(y - other.y)

  def neighbours: List[Pos] = List(
    Pos(x - 1, y - 1),
    Pos(x,     y - 1),
    Pos(x + 1, y - 1),
    Pos(x - 1, y    ),
    Pos(x + 1, y    ),
    Pos(x - 1, y + 1),
    Pos(x    , y + 1),
    Pos(x + 1, y + 1),
  )

  def neighbours4: List[Pos] = List(
    Pos(x, y - 1),
    Pos(x - 1, y),
    Pos(x + 1, y),
    Pos(x, y + 1),
  )

  def move(dx: Int = 0, dy: Int = 0): Pos = Pos(x + dx, y + dy)

  def move(shift: (Int, Int)): Pos = shift match {
    case (dx, dy) => move(dx, dy)
  }

  def diff(other: Pos): (Int, Int) = (x - other.x, y - other.y)
}
