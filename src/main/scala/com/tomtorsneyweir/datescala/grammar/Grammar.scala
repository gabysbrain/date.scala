package com.tomtorsneyweir.datescala.grammar

import scala.util.parsing.combinator._

import com.eaio.util.text.HumanTime

class Timespan extends JavaTokenParsers {
  
  sealed trait Unit
  case object Weeks extends Unit
  case object Days extends Unit
  case object Hours extends Unit
  case object Minutes extends Unit
  case object Seconds extends Unit
  case object Millis extends Unit

  def value : Parser[Long] = rep(timeCode) ^^ (_.sum)

  def timeCode : Parser[Long] = 
    (duration ~ unit) ^^ {case (d ~ u) => u match {
      case Weeks   => (d * 7 * 24 * 60 * 60 * 1000).toLong
      case Days    => (d * 24 * 60 * 60 * 1000).toLong
      case Hours   => (d * 60 * 60 * 1000).toLong
      case Minutes => (d * 60 * 1000).toLong
      case Seconds => (d * 1000).toLong
      case Millis  => d.toLong
    }
  }

  def duration : Parser[Double] = floatingPointNumber ^^ (_.toDouble)
  def unit : Parser[Unit] = weeks | days | hours | millis | minutes | seconds 

  def weeks : Parser[Unit] = 
    ("weeks" | "wks" | "w") ^^ {_ => Weeks}
  def days : Parser[Unit] = 
    ("days" | "d") ^^ {_ => Days}
  def hours : Parser[Unit] = 
    ("hours" | "hrs" | "h") ^^ {_ => Hours}
  def minutes : Parser[Unit] = 
    ("minutes" | "min" | "mins" | "m") ^^ {_ => Minutes}
  def seconds : Parser[Unit] = 
    ("seconds" | "sec" | "secs" | "s") ^^ {_ => Seconds}
  def millis : Parser[Unit] = 
    ("milliseconds" | "ms" | "millis") ^^ {_ => Millis}
}

