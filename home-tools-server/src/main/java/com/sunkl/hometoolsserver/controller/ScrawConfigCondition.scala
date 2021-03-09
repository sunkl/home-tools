package com.sunkl.hometoolsserver.controller

import com.sunkl.hometoolsserver.dao.ScrawConfig
import com.sunkl.hometoolsserver.service.ScrawConfigService
import com.sunkl.hometoolsserver.utils.JSONUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{CrossOrigin, GetMapping, RequestMapping, RequestParam, RestController}
import com.sunkl.hometoolsserver.utils.UdImplict._

@RestController
@RequestMapping(Array("/api/setting/scraw_config"))
class ScrawConfigCondition @Autowired()(
                                         val scrawConfigService: ScrawConfigService
                                       ) {
  @CrossOrigin
  @GetMapping(Array("/selectByLikeScrawName"))
  def selectByLikeScrawName(@RequestParam("scraw_name") scrawName: String): String = {
    val list = if (scrawName.isNotNullEmptyTrim) {
      scrawConfigService.selectLikeName(scrawName).map(element => s"""{"value":"${element.getScrawId}","label":"${element.getScrawName}"}""")
    } else {
      scrawConfigService.selectAll().map(element => s"""{"value":"${element.getScrawId}","label":"${element.getScrawName}"}""")
    }
    s"[${list.mkString(",")}]"
  }

  @CrossOrigin
  @GetMapping(Array("/selectById"))
  def selectByScrawId(@RequestParam("scraw_id") scrawId: Integer): String = {
    val scrawConfig = scrawConfigService.selectByScrawId(scrawId)
    JSONUtils.object2JsonString(scrawConfig)
  }

  @CrossOrigin
  @GetMapping(Array("/addParamByScrawId"))
  def addParamByScrawId(@RequestParam("scraw_id") scrawId: Integer, @RequestParam("param_name") paramName: String, @RequestParam("param_value") paramValue: String): String = {
    scrawConfigService.addAndUpdateParam(scrawId, paramName, paramValue)
    JSONUtils.object2JsonString(scrawConfigService.selectByScrawId(scrawId))
  }

  @CrossOrigin
  @GetMapping(Array("/addUpdateResultCol"))
  def addUpdateColByScrawId(@RequestParam("scraw_id") scrawId: Integer,
                            @RequestParam("col_name") colName: String,
                            @RequestParam("col_data_type") colDataType: String,
                            @RequestParam("col_desc") colDesc: String): String = {
    scrawConfigService.addReusltCol(scrawId, colName, colDataType, colDesc)
    JSONUtils.object2JsonString(scrawConfigService.selectByScrawId(scrawId))
  }


  @CrossOrigin
  @GetMapping(Array("/createOrUpdateBaseConfig"))
  def createOrUpdateBaseConfig(
                                @RequestParam("scraw_id") scrawId: Integer,
                                @RequestParam("create_scraw_name") crateScrawName: String,
                                @RequestParam("scraw_url") scrawURL: String,
                                @RequestParam("scraw_persist_type") scrawPersistType: String,
                                @RequestParam("create_or_update") createOrUpdate: String,
                                @RequestParam("dbName") dbName: String,
                                @RequestParam("tableName") tableName: String,
                                @RequestParam("scraw_desc") scrawDesc: String,
                                @RequestParam("scraw_action_start_time") scrawActionStartTime: String,
                                @RequestParam("action_frequency_num") actionFrequencyNum: String,
                                @RequestParam("action_frequency_unit") actionFrequencyUnit: String
                              ): String = {
    val scrawPersistConfig = s"""{"scraw_persist_type":"${scrawPersistType}","scraw_db_name":"${dbName}","scraw_table_name":"${tableName}"}"""
    if ( scrawId>0) {
      scrawConfigService.updateScrawBaseConfig(new ScrawConfig(
        scrawId, crateScrawName,scrawDesc, scrawURL, null, null, scrawPersistConfig, scrawActionStartTime, actionFrequencyNum, actionFrequencyUnit
      ))
      JSONUtils.object2JsonString(scrawConfigService.selectByScrawId(scrawId))
    } else {
      scrawConfigService.createScraw(new ScrawConfig(crateScrawName, scrawDesc, scrawURL, "[]", "[]", "{}", scrawActionStartTime, actionFrequencyNum, actionFrequencyUnit))
      JSONUtils.object2JsonString(scrawConfigService.selectByScrawName(crateScrawName))
    }
  }

/*
  /**
   * 更新进本配置信息
   *
   * @param scrawId
   * @param scrawURL
   * @param scrawPersistType
   * @param dbName
   * @param tableName
   * @return
   */
  @CrossOrigin
  @GetMapping(Array("/updateScrawBaseConfig"))
  def updateScrawBaseConfig(
                             @RequestParam("scraw_id") scrawId: Integer,
                             @RequestParam("scraw_url") scrawURL: String,
                             @RequestParam("scraw_persist_type") scrawPersistType: String,
                             @RequestParam("dbName") dbName: String,
                             @RequestParam("tableName") tableName: String): String = {
    scrawConfigService.updateScrawBaseConfig(scrawId, scrawURL, scrawPersistType, dbName, tableName)
    JSONUtils.object2JsonString(scrawConfigService.selectByScrawId(scrawId))
  }*/

  @CrossOrigin
  @GetMapping(Array("/createScrawName"))
  def createScrawName(@RequestParam("scraw_name") scrawName: String): String = {
    scrawConfigService.createScraw(new ScrawConfig(scrawName))
  }

  @CrossOrigin
  @GetMapping(Array("/deleteById"))
  def deleteById(@RequestParam("scraw_id") scrawId: Integer): Boolean = {
    scrawConfigService.deleteById(scrawId)
  }

  @CrossOrigin
  @GetMapping(Array("/updateResultColByScrawId"))
  def updateResultColByScrawId(
                                @RequestParam("scraw_id") scrawId: Integer,
                                @RequestParam("col_index") colIndex: Int,
                                @RequestParam("col_param_value") colParamValue: String,
                                @RequestParam("col_param_type") colParamType: String): String = {
    scrawConfigService.updateResultColPram(scrawId, colIndex, colParamValue, colParamType)
    JSONUtils.object2JsonString(scrawConfigService.selectByScrawId(scrawId))
  }

  @CrossOrigin
  @GetMapping(Array("/updateUrlParamByScrawId"))
  def updateUrlParamByScrawId(
                               @RequestParam("scraw_id") scrawId: Integer,
                               @RequestParam("parma_index") paramIndex: Int,
                               @RequestParam("param_value") paramValue: String,
                               @RequestParam("update_type") updateType: String): String = {
    scrawConfigService.updateUrlParam(scrawId, paramIndex, paramValue, updateType)
    JSONUtils.object2JsonString(scrawConfigService.selectByScrawId(scrawId))
  }

}