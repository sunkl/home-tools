package com.sunkl.hometoolsserver.service

import com.sunkl.hometoolsserver.dao.EmailMsg
import com.sunkl.hometoolsserver.dao.email.html.HTMLScrpt
import com.sunkl.hometoolsserver.mapper.EmailMsgMapper
import com.sunkl.hometoolsserver.utils.EmailUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import org.springframework.context.annotation.PropertySource

@Service("emailMsgService")
class EmailMsgService @Autowired()(

                                    val userService: FamilyUserService,
                                    val emailMsgMapper: EmailMsgMapper,
                                    val emailUtils: EmailUtils
                                  ) {

  def testSendEmailMsg(userId: String): String = {
    val users = userService.findUserByUserId(userId)
    val htmlScript = HTMLScrpt(users)
      .addTable("股东变更",
        Array("股票代码", "公司名称", "持股人名字", "变更股数"),
        Array[Array[String]](
          Array("100001", "中国煤矿", "孙昆仑", "2000"),
          Array("100002", "中国煤矿", "牛换青", "2000")
        )
      ).addTable("新股申购",
      Array("股票代码", "公司名称", "购买起始时间"),
      Array[Array[String]](
        Array("100001", "中国煤矿", "2020-01-01"),
        Array("100002", "中国煤矿", "2020-01-1")
      )
    ).toHtmlScript()
    val emailMsg = new EmailMsg("934926112@qq.com", users.getUserEmail, "股市动态", htmlScript)
    emailUtils.send(emailMsg)
    "true"
  }


}
