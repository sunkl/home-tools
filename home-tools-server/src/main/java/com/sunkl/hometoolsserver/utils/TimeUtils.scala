package com.sunkl.hometoolsserver.utils

import java.time.{LocalDate, LocalDateTime}
import java.time.format.DateTimeFormatter
import UdImplict._

object TimeUtils {
  private[utils] val defaulDateTimeFormat = "yyyy-MM-dd HH:mm:ss"
  private[utils] val defaulDateFormat = "yyyy-MM-dd"

  def getCurrentDateTime: String = {
    val localDateTime = LocalDateTime.now
    localDateTime.format(defaulDateTimeFormat.toDateTimeFromat)
  }

  def getYesterdayDate: String = {
    val today = LocalDate.now
    today.plusDays(-1).format(defaulDateFormat.toDateTimeFromat)
  }

  private def getCurrentLocalDateTime() = {
    LocalDateTime.now()
  }

  def getDateTimePlusMin(minNum: Int) = {
    this.getCurrentLocalDateTime().plusMinutes(minNum).format(defaulDateTimeFormat.toDateTimeFromat)
  }
}
