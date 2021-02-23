package com.sunkl.hometoolsserver.scheduling

import com.sunkl.hometoolsserver.service.SchdulerTaskConfigService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class EmailScheduling @Autowired()(
                                    val schdulerTaskConfigService: SchdulerTaskConfigService
                                  ) {

  /*每5分钟更新一次定时任务配置*/
  @Scheduled(cron = "0 0/5 * * * ? *")
  def createEmail(): Unit = {
    schdulerTaskConfigService.selectLastUpdateScheduler()
  }
}
