package com.sunkl.hometoolsserver.service

import com.sunkl.hometoolsserver.mapper.EmailMsgMapper
import com.sunkl.hometoolsserver.utils.EmailUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("emailMsgService")
class EmailMsgService @Autowired()(
                                    val emailMsgMapper: EmailMsgMapper,
                                    val emailUtils: EmailUtils
                                  ) {


  def testSendEmailMsg(userId: String): String = {
    emailMsgMapper.selectEmailMsgByCondition("!is_send").forEach(emailMsg => {
      emailUtils.send(emailMsg)
    })
    "true"
  }


}
