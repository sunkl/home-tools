package com.sunkl.hometoolsserver.service

import com.sunkl.hometoolsserver.dao.email.html.HTMLScrpt
import com.sunkl.hometoolsserver.dao.{EmailMsg, EmailSendConfig, EmailSendConfigAll, EmailSendConfigAllUnit, StockHolderChange}
import com.sunkl.hometoolsserver.mapper.EmailMsgMapper
import com.sunkl.hometoolsserver.utils.{EmailUtils, TimeUtils}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConverters._
import com.sunkl.hometoolsserver.utils.UdImplict._
import org.springframework.context.annotation.PropertySource
import org.springframework.beans.factory.annotation.Value

import java.util
import scala.collection.{immutable, mutable}

@Service("emailMsgService")
@PropertySource(Array("classpath:application.properties"))
class EmailMsgService @Autowired()(
                                    val userService: FamilyUserService,
                                    val emailMsgMapper: EmailMsgMapper,
                                    val emailSendConfigService: EmailSendConfigService,
                                    val emailUtils: EmailUtils,
                                    val stockHolderChangeService: StockHolderChangeService,
                                    val stockHoldingChangeSeniorManagermentService: StockHoldingChangeSeniorManagermentService
                                  ) {

  @Value("${spring.mail.username}") var srcEmailAddr: String = _

  def testSendEmailMsg(userId: String): String = {
    //    val users = userService.findUserByUserId(userId)
    //    val htmlScript = HTMLScrpt(users)
    //      .addTable("股东变更",
    //        Array("股票代码", "公司名称", "持股人名字", "变更股数"),
    //        Array[Array[String]](
    //          Array("100001", "中国煤矿", "孙昆仑", "2000"),
    //          Array("100002", "中国煤矿", "牛换青", "2000")
    //        )
    //      ).addTable("新股申购",
    //      Array("股票代码", "公司名称", "购买起始时间"),
    //      Array[Array[String]](
    //        Array("100001", "中国煤矿", "2020-01-01"),
    //        Array("100002", "中国煤矿", "2020-01-1")
    //      )
    //    ).toHtmlScript()
    //    val emailMsg = new EmailMsg("934926112@qq.com", users.getUserEmail, "股市动态", htmlScript)
    //    emailUtils.send(emailMsg)
    this.generEmail(TimeUtils.getYesterdayDate)
    val allEmail = this.selectByAll()
    allEmail.foreach(emailMsg => {
      emailUtils.send(emailMsg)
    })
    val allEmailID = allEmail.map(_.getEmailMsgId)
    this.updateEmailIsSend(allEmailID, "true")
    "true"
  }

  def updateEmailIsSend(emailMsgIds: List[Integer], isSend: String): Unit = {
    val currenDateTime = TimeUtils.getCurrentDateTime
    emailMsgMapper.updateIsSend(emailMsgIds.map(id => s"'${id.toString}'").mkString(","), isSend, currenDateTime)
  }

  def selectByAll(): List[EmailMsg] = {
    emailMsgMapper.selectByCondition("is_send='false'").asScala.toList
  }

  def generEmail(date: String) = {
    val emailSendConfigs: List[EmailSendConfig] = emailSendConfigService.selectAll().asScala.toList
    if (emailSendConfigs.nonEmpty) {
      val emailMsgs: util.List[EmailMsg] = emailSendConfigs
        .groupBy(_.getUserId)
        .map { case (userId, configs) => EmailSendConfigAllUnit.apply(userId.toString, configs) }
        .filter(_.isAviliable())
        .map(config => {
          val user = userService.findUserByUserId(config.userId)
          val htmlScript = HTMLScrpt(user)
          /*公司公告信息*/
          if (config.companyAnnouncementStockCodes.isNotNullEmptyTrim) {
            //            config.companyAnnouncementStockCodes.split(",")
          }
          /*大股东持股变更信息*/
          if (config.stockHoldingChangeStockCodes.isNotNullEmptyTrim) {
            val shcStockCodes = config.stockHoldingChangeStockCodes.split(",")
            if (shcStockCodes.nonEmpty) {
              val tableHTML = stockHolderChangeService.selectByStockCodeAndDateAndToTabelHtml(shcStockCodes, date)
              htmlScript.addTable(tableHTML)
            }
          }
          /*公司高管持股变更信息*/
          if (config.stockHoldingChangeSeniorManagerStockCodes.isNotNullEmptyTrim) {
            val shcsmStockCode = config.stockHoldingChangeSeniorManagerStockCodes.split(",")
            if (shcsmStockCode.nonEmpty) {
              val htmlTable = stockHoldingChangeSeniorManagermentService.selectByStockCodeAndDateToHtmlTable(shcsmStockCode, date)
              htmlScript.addTable(htmlTable)
            }
          }
          val emailMessage = htmlScript.toHtmlScript()
          new EmailMsg(srcEmailAddr, user.getUserEmail, config.emailObject, emailMessage)
        }).toList.asJava
      emailMsgMapper.insertIntoAll(emailMsgs)

    }
  }
}
