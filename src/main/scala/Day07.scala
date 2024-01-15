package me.astynax.adventofcode2017

object Day07 {
  type Input = Map[Name, (Int, List[Name])]

  case class Name(name: String)

  def step1(input: Input): Name = bases(input).find(_._2.isEmpty).get._1

  def step2(input: Input): Int = {
    val root = step1(input)

    def check(node: Name): Either[Int, Int] = {
      val (value, cs) = input(node)
      if (cs.isEmpty) Left(value)
      else {
        var checks = Map.empty[Int, List[Name]]
        cs.map(x => x -> check(x))
          .foreach {
            case (_, Right(x)) => return Right(x)
            case (n, Left(x)) => checks = checks.updated(x, n :: checks.getOrElse(x, List()))
          }
        if (checks.size == 1) {
          val (v, ns) = checks.head
          Left(v * ns.size + value)
        } else {
          checks.find { case (_, ns) => ns.size == 1 } match {
            case Some((v, List(n))) =>
              val norm = checks.keys.find(_ != v).get
              Right(input(n)._1 + norm - v)
            case _ => throw new IllegalArgumentException("Impossible!")
          }
        }
      }
    }

    check(root).toOption.get
  }

  def bases(input: Input): Map[Name, Option[Name]] = {
    val noBases = input.keys.map(_ -> Option.empty[Name]).toMap
    val bases = input.flatMap {
      case (base, (_, cs)) => cs.map(_ -> Some(base))
    }
    noBases ++ bases
  }

  def decode(lines: List[String]): Input = (for {
    line <- lines
    name :: num :: rest <- List(line.split(raw"\s+").toList)
    weight = num.stripPrefix("(").stripSuffix(")").toInt
    children = rest.drop(1).map { s => Name(s.stripSuffix(",")) }
  } yield Name(name) -> (weight, children)).toMap

  lazy val input: Input = decode(Input.linesFrom("Day07.input"))
}
