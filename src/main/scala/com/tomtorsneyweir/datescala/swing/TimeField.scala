package com.tomtorsneyweir.datescala.swing

import com.tomtorsneyweir.datescala.Date

import scala.swing.TextField

class TimeField extends TextField {

  /**
   * returns the time from the text field in millis
   */
  def millis : Option[Long] = Date.string2Millis(text)

  def millis_=(m:Long) = {
    text = Date.millis2Exact(m)
  }
}

