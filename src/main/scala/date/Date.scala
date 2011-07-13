package date.scala

import date.scala.grammar.Timespan
import scala.util.parsing.combinator._

object Date extends Timespan {
  def main(args:Array[String]) {
    println("input: " + args(0))
    println(parseAll(value, args(0)))
    //val fst :: _ = parseAll(value, args(0))
  }
}

