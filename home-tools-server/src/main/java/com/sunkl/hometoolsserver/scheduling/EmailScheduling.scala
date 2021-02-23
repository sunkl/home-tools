package com.sunkl.hometoolsserver.scheduling

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class EmailScheduling {
  @Scheduled(cron = "0 7 19 * * ? ")
  def createEmail() = {
    println("定时任务！。。。。。。。。。")
  }
}
