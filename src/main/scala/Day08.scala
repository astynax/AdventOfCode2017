package me.astynax.adventofcode2017

object Day08 {
  type Input = List[Step]

  object IncDec extends Enumeration {
    type IncDec = Value
    val Inc, Dec = Value

    def apply(incDec: IncDec): (Int, Int) => Int = incDec match {
      case Inc => _ + _
      case Dec => _ - _
    }

    def fromString: String => IncDec = {
      case "inc" => Inc
      case "dec" => Dec
      case s => throw new IllegalArgumentException(s"Bad op: $s")
    }
  }

  import IncDec._

  object Comparison extends Enumeration {
    type Comparison = Value
    val Eq, NEq, Gt, GtE, Lt, LtE = Value

    def apply(comparison: Comparison): (Int, Int) => Boolean = comparison match {
      case Eq => _ == _
      case NEq => _ != _
      case Gt => _ > _
      case GtE => _ >= _
      case Lt => _ < _
      case LtE => _ <= _
    }

    def fromString: String => Comparison = {
      case "==" => Eq
      case "!=" => NEq
      case ">" => Gt
      case ">=" => GtE
      case "<" => Lt
      case "<=" => LtE
      case s => throw new IllegalArgumentException(s"Bad comparison: $s")
    }
  }

  import Comparison._

  case class Step(target: Register,
                  op: IncDec,
                  amount: Int,
                  ifRegister: Register,
                  comparison: Comparison,
                  comparisonArgument: Int)

  case class Register(name: String)

  def decode(lines: List[String]): Input = lines.map { line =>
    val List(r, o, a, "if", i, c, v) = line.split(raw"\s+").toList
    Step(
      target = Register(r),
      op = IncDec.fromString(o),
      amount = a.toInt,
      ifRegister = Register(i),
      comparison = Comparison.fromString(c),
      comparisonArgument = v.toInt,
    )
  }

  def steps(input: Input): (Int, Int) = {
    val (memory, max) = input.foldLeft(
      (Map.empty[Register, Int], 0)
    ) { (state, step) =>
      val (mem, max) = state
      if (Comparison(step.comparison)(
        mem.getOrElse(step.ifRegister, 0),
        step.comparisonArgument
      )) {
        val newValue = IncDec(step.op)(
          mem.getOrElse(step.target, 0),
          step.amount,
        )
        (mem.updated(step.target, newValue), max max newValue)
      }
      else state
    }

    (memory.values.max, max)
  }

  lazy val input: Input = decode(Input.linesFrom("Day08.input"))
}
