package date.scala

import date.scala.grammar.Timespan
import com.eaio.util.text.HumanTime
import scala.util.parsing.combinator._

object Date extends Timespan {
  def main(args:Array[String]) {
    println("input: " + args(0))
    println(parseAll(value, args(0)))
    //val fst :: _ = parseAll(value, args(0))
  }

  def string2Millis(s:String) : Long = parseAll(value, s)

  def millis2Exact(m:Long) : String = HumanTime.exactly(m)
  def millis2Approx(m:Long) : String = HumanTime.approximately(m)
}

