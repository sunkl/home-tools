package com.sunkl.hometoolsserver.utils

import java.util

object UdImplict {


  implicit class ExtendString(input: String) {
    def repeatNum(num: Int): String = {
      StringUtils.repeatStr(input, num)
    }

    def swapHtml(htmlElement: String, step: Int = 0, isExpland: Boolean = false): String = {
      val valueSuffSpace = " ".repeatNum(step * HtmlUtils.spaceNumPerStemp)
      val elementSuffSpace = " ".repeatNum((step - 1) * HtmlUtils.spaceNumPerStemp)
      if (!isExpland) {
        s"<$htmlElement>$input</$htmlElement>"
      } else {
        s"<$htmlElement>\n${valueSuffSpace}$input\n${elementSuffSpace}</$htmlElement>"
      }
    }
  }

  implicit class ExtendArrayStr(input: Array[String]) {
    def swapHtml(parentElement: String, sonElement: String, step: Int = 0): String = {
      //      val valueSuffSpace = " ".repeatNum(step * HtmlUtils.spaceNumPerStemp)
      input.map(elment => elment.swapHtml(sonElement)).mkString(s"\n").swapHtml(parentElement, step, true)
    }

    def swapHtml(parentElement: String, step: Int): String = {
      //      val valueSuffSpace = " ".repeatNum((step - 1) * HtmlUtils.spaceNumPerStemp)
      input.mkString(s"\n").swapHtml(parentElement, step, true)
    }
  }

  implicit class ExtendStr(input: String) {
    def isNull = input == null

    def isNotNull = !input.isNull

    def isNullEmpty = input.isNull || input.isEmpty

    def isNotNullEmpty = !input.isNullEmpty

    def isNullEmptyTrim = input.isNullEmpty || input.trim.isEmpty

    def isNotNullEmptyTrim = !input.isNullEmptyTrim
  }

}
