package me.astynax.adventofcode2017

import scala.annotation.tailrec
import scala.math.{floor, floorMod, pow, sqrt}

object Day03 {
  def step1(input: Int): Int = {
    val s = floor(sqrt(input)).toInt
    val n = if (floorMod(s, 2) == 0) s - 1 else s
    val n2 = pow(n, 2).toInt
    val p = (pow(n + 2, 2).toInt - n2) / 4
    val r = floorMod(input - n2, p)
    if (r < p / 2) p - r
    else r
  }

  def step2(input: Int): Int = {
    @tailrec
    def go(memory: Map[Pos, Int], pos: Pos, level: Int = 1): Int = {
      val ps = fullTurn(pos, level)
      val newMemory = ps.foldLeft(memory) { (m, p) =>
        m.updated(p, p.neighbours.map(m.getOrElse(_, 0)).sum)
      }
      ps.find(newMemory(_) > input) match {
        case Some(v) => newMemory(v)
        case None => go(newMemory, ps.last, level + 1)
      }
    }

    go(Map(Pos(0, 0) -> 1), Pos(0, 0))
  }

  def fullTurn(start: Pos, level: Int): List[Pos] = {
    val repeat = List.fill[(Int, Int)](2 * level)(_)
    List.concat(
      repeat((0, -1)).tail,
      repeat((-1, 0)),
      repeat((0, 1)),
      repeat((1, 0)),
    ).scanLeft(start.move(dx = 1))(_.move(_))
  }

  val input: Int = 347991
}
