package com.sunkl.hometoolsserver.utils

object StringUtils {
  def repeatStr(elementChar: String, num: Int) = {
    Array.fill(num)(elementChar).mkString("")
  }

}
