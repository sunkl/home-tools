package com.sunkl.hometoolsserver.controller

import com.sunkl.hometoolsserver.service.ScrawConfigService
import com.sunkl.hometoolsserver.utils.JSONUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{CrossOrigin, GetMapping, RequestMapping, RequestParam, RestController}

@RestController
@RequestMapping(Array("/api/setting/scraw_config"))
class ScrawConfigCondition @Autowired()(
                                         val scrawConfigService: ScrawConfigService
                                       ) {
  @CrossOrigin
  @GetMapping(Array("/selectByLikeScrawName"))
  def selectByLikeScrawName(@RequestParam("scraw_name") scrawName: String): String = {
    val list = scrawConfigService.selectLikeName(scrawName).map(element => s"""{"value":"${element.getScrawId}","label":"${element.getScrawName}"}""")
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
    scrawConfigService.addAndUpdateReusltCol(scrawId, colName, colDataType, colDesc)
    JSONUtils.object2JsonString(scrawConfigService.selectByScrawId(scrawId))
  }

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
  }
}
