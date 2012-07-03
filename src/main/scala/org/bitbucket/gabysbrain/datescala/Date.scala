package org.bitbucket.gabysbrain.datescala

import org.bitbucket.gabysbrain.datescala.grammar.Timespan
import com.eaio.util.text.HumanTime
import scala.util.parsing.combinator._

object Date extends Timespan {
  def main(args:Array[String]) {
    println("input: " + args(0))
    println(parseAll(value, args(0)))
    //val fst :: _ = parseAll(value, args(0))
  }

  def string2Millis(s:String) : Option[Long] = {
    val p = parseAll(value, s)
    if(p.successful) Some(p.get)
    else             None
  }

  def millis2Exact(m:Long) : String = HumanTime.exactly(m)
  def millis2Approx(m:Long) : String = HumanTime.approximately(m)
}

