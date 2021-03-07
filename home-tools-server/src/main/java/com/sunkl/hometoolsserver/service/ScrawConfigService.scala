package com.sunkl.hometoolsserver.service

import com.alibaba.fastjson.JSON
import com.sunkl.hometoolsserver.dao.{ResultSchema, ScrawConfig}
import com.sunkl.hometoolsserver.mapper.ScrawConfigMapper
import com.sunkl.hometoolsserver.utils.JSONUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import collection.JavaConverters._
import com.sunkl.hometoolsserver.utils.UdImplict._

@Service
class ScrawConfigService @Autowired()(
                                       val scrawConfigMapper: ScrawConfigMapper
                                     ) {
  /**
   * 查询所有
   *
   * @return
   */
  def selectAll(): List[ScrawConfig] = {
    scrawConfigMapper.selectByCondition("1=1").asScala.toList
  }

  /**
   * 按照名字模糊查询
   *
   * @param scrawNameScriptStr
   * @return
   */
  def selectLikeName(scrawNameScriptStr: String): List[ScrawConfig] = {
    scrawConfigMapper.selectByCondition(s"scraw_name like '%${scrawNameScriptStr}%'").asScala.toList
  }

  /**
   * 添加或者更新参数
   *
   * @param scrawConfigId
   * @param paramName
   * @param paramValue
   */
  def addAndUpdateParam(scrawConfigId: Integer, paramName: String, paramValue: String): Unit = {
    val scrawConfig: ScrawConfig = scrawConfigMapper.selectByPrimaryKey(scrawConfigId)
    val jSONObject = scrawConfig.getScrawParams.toJsonObject()
    jSONObject.put(paramName, paramValue)
    scrawConfig.setScrawParams(jSONObject.toJSONString)
    scrawConfigMapper.updateByPrimaryKey(scrawConfig)
  }

  /**
   * 删除参数
   *
   * @param scrawConfigId
   * @param paramName
   */
  def deleteParam(scrawConfigId: Integer, paramName: String): Unit = {
    val scrawConfig: ScrawConfig = scrawConfigMapper.selectByPrimaryKey(scrawConfigId)
    val jSONObject = scrawConfig.getScrawParams.toJsonObject()
    jSONObject.remove(paramName)
    scrawConfig.setScrawParams(jSONObject.toJSONString)
    scrawConfigMapper.updateByPrimaryKey(scrawConfig)
  }

  /**
   * 添加列
   *
   * @param scrawConfigId
   * @param colName
   * @param colDataType
   * @param colDesc
   * @return
   */
  def addAndUpdateReusltCol(scrawConfigId: Integer, colName: String, colDataType: String, colDesc: String): Boolean = {
    val scrawConfigTmp = scrawConfigMapper.selectByPrimaryKey(scrawConfigId)
    var resultSchema: Map[String, ResultSchema] = JSON.parseArray[ResultSchema](scrawConfigTmp.getScrawResultSchema, classOf[ResultSchema])
      .iterator().asScala.toArray
      .map(element => (element.colName, element)).toMap
    resultSchema += (colName -> ResultSchema(colName, colDataType, colDesc))
    val jsonStr = JSONUtils.object2JsonString(resultSchema.values.toArray)
    scrawConfigTmp.setScrawResultSchema(jsonStr)
    scrawConfigMapper.updateByPrimaryKey(scrawConfigTmp) > 1
  }

  /**
   * 删除列
   *
   * @param scrawConfigId
   * @param colName
   */
  def deleteResultCol(scrawConfigId: Integer, colName: String): Boolean = {
    val scrawConfig = scrawConfigMapper.selectByPrimaryKey(scrawConfigId)
    var resultSchemaMap: Map[String, ResultSchema] = JSON.parseArray[ResultSchema](scrawConfig.getScrawResultSchema, classOf[ResultSchema])
      .iterator().asScala
      .toArray.map(element => (element.colName, element)).toMap
    resultSchemaMap -= colName
    val jsonStr = JSONUtils.object2JsonString(resultSchemaMap.values.toArray)
    scrawConfig.setScrawResultSchema(jsonStr)
    scrawConfigMapper.updateByPrimaryKey(scrawConfig) > 1
  }
}
