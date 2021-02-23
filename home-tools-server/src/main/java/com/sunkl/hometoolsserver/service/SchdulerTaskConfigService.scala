package com.sunkl.hometoolsserver.service

import com.sunkl.hometoolsserver.MemoryCache
import com.sunkl.hometoolsserver.dao.SchulerTaskConfig
import com.sunkl.hometoolsserver.mapper.SchulerTaskConfigMapper
import com.sunkl.hometoolsserver.utils.TimeUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConverters._

@Service
class SchdulerTaskConfigService @Autowired()(
                                              val schdulerTaskConfigMapper: SchulerTaskConfigMapper
                                            ) {
  /**
   * 查询所有定时任务配置
   *
   * @return
   */
  def selectAll(): List[SchulerTaskConfig] = {
    schdulerTaskConfigMapper.selectSTCByCondition("1=1").asScala.toList
  }

  def selectLastManyMinUpdateConfig(minute: Int = -5): List[SchulerTaskConfig] = {
    val fiveMinBeforDateTime = TimeUtils.getDateTimePlusMin(minute)
    schdulerTaskConfigMapper.selectSTCByCondition(s"date(update_time)>date(${fiveMinBeforDateTime})")
      .asScala
      .toList
  }

  def selectLastUpdateScheduler(): List[SchulerTaskConfig] = {
    if (MemoryCache.schulerTaskConfigs == null) {
      MemoryCache.schulerTaskConfigs = this.selectAll()
    } else {
      MemoryCache.schulerTaskConfigs = this.selectLastManyMinUpdateConfig()
    }
    MemoryCache.schulerTaskConfigs
  }
}
