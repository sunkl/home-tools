package com.sunkl.hometoolsserver.dao

import com.sunkl.hometoolsserver.utils.UdImplict._

case class EmailSendConfigAll(
                               var userId: String = null,
                               var alertStartDate: String = null,
                               var alertStartTime: String = null,
                               var alertEndTime: String = null,
                               var alertIntervalHour: Int = -1,
                               var companyAnnouncementStockCodes: String = null,
                               var emailAlterEnable: Boolean = false,
                               var stockHoldingChangeStockCodes: String = null,
                               var stockHoldingChangeSeniorManagerStockCodes: String = null,
                               var emailObject: String = "股票变更信息提醒"
                             ) {
  def isAviliable(): Boolean = {
    this.alertStartDate.isNotNullEmptyTrim &&
      this.alertEndTime.isNotNullEmptyTrim &&
      this.alertEndTime.isNotNullEmptyTrim &&
      this.alertIntervalHour > 0 &&
      (
        this.companyAnnouncementStockCodes.isNotNullEmptyTrim ||
          this.stockHoldingChangeStockCodes.isNotNullEmptyTrim ||
          this.stockHoldingChangeSeniorManagerStockCodes.isNotNullEmptyTrim
        )
  }
}

object EmailSendConfigAllUnit {
  def apply(userIdTmp: String, emailSendConfigs: List[EmailSendConfig], emailObjectTmp: String = "股票变更信息提醒"): EmailSendConfigAll = {
    require(emailSendConfigs.nonEmpty)
    val map: Map[String, EmailSendConfig] = emailSendConfigs.map(e => (e.getItemType, e)).toMap
    val alertStartDate = getConfigStrValue(map, "alert_start_date")
    val alterEndTime = getConfigStrValue(map, "alter_end_time")
    val alterIntervalHour = getConfigStrValue(map, "alter_interval_hour", "0").toInt
    val alterStartTime = getConfigStrValue(map, "alter_start_time")
    val companyAnnouncementStockCodes = getConfigStrValue(map, "company_announcement", "")
    val emailAlterEnable = getConfigStrValue(map, "email_alter_enable", "false").toBoolean
    val stockHoldingChange = getConfigStrValue(map, "stock_holding_change", "")
    val stockHoldingChangeSeniorManager = getConfigStrValue(map, "stock_holding_change_senior_manager", "")
    EmailSendConfigAll(
      userId = userIdTmp,
      alertStartDate = alertStartDate,
      alertStartTime = alterStartTime,
      alertEndTime = alterEndTime,
      alertIntervalHour = alterIntervalHour,
      companyAnnouncementStockCodes = companyAnnouncementStockCodes,
      emailAlterEnable = emailAlterEnable,
      stockHoldingChangeStockCodes = stockHoldingChange,
      stockHoldingChangeSeniorManagerStockCodes = stockHoldingChangeSeniorManager,
      emailObject = emailObjectTmp
    )
  }

  private[this] def getConfigStrValue(map: Map[String, EmailSendConfig], itmeType: String, defaultValue: String = null): String = {
    map.get(itmeType) match {
      case Some(emailSendConfig: EmailSendConfig) => emailSendConfig.getItemMessage
      case None => defaultValue
    }
  }
}