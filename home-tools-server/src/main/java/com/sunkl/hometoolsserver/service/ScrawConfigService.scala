package com.sunkl.hometoolsserver.service

import com.alibaba.fastjson.{JSON, JSONArray, JSONObject}
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
    if (scrawNameScriptStr.isNullEmptyTrim) {
      scrawConfigMapper.selectByCondition(s"1=1").asScala.toList
    } else {
      scrawConfigMapper.selectByCondition(s"scraw_name like '%${scrawNameScriptStr}%'").asScala.toList
    }
  }

  def selectByScrawId(id: Integer): ScrawConfig = {
    val scrawConfig = scrawConfigMapper.selectByPrimaryKey(id)
    if (!scrawConfig.getScrawResultSchema.trim.startsWith("[") || !scrawConfig.getScrawResultSchema.trim.endsWith("]")) {
      scrawConfig.setScrawResultSchema("[]")
    }
    if (!scrawConfig.getScrawParams.trim.startsWith("[") || !scrawConfig.getScrawParams.trim.endsWith("]")) {
      scrawConfig.setScrawParams("{}")
    }
    scrawConfig
  }

  /**
   * 添加或者更新参数
   *
   * @param scrawConfigId
   * @param paramName
   * @param paramValue
   */
  def addAndUpdateParam(scrawConfigId: Integer, paramName: String, paramValue: String): Boolean = {
    if (paramName.isNotNullEmptyTrim) {
      val scrawConfig: ScrawConfig = scrawConfigMapper.selectByPrimaryKey(scrawConfigId)
      val jsonArr = if (scrawConfig.getScrawParams.trim.startsWith("[") && scrawConfig.getScrawParams.trim.endsWith("]")) {
        scrawConfig.getScrawParams.toJsonArray()
      } else {
        "[]".toJsonArray()
      }
      val jSONObjectMap = jsonArr.toArray(Array[JSONObject]())
        .map(element => (element.getString("param_name"), element))
        .toMap + (paramName -> JSON.parse(s"""{"param_name":"${paramName}","param_value":"${paramValue}"}"""))
      val arrStr = jSONObjectMap.values.map(element => JSONUtils.object2JsonString(element)).mkString(",")
      scrawConfig.setScrawParams(s"[${arrStr}]")
      scrawConfigMapper.updateByPrimaryKey(scrawConfig) > 0
    } else {
      false
    }
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
    var resultSchema: Map[String, ResultSchema] = if (scrawConfigTmp.getScrawResultSchema.isNotNullEmptyTrim) {
      JSON.parseArray(scrawConfigTmp.getScrawResultSchema)
        .toArray(Array[JSONObject]())
        .map(element => (element.getString("col_name"), new ResultSchema(element.getString("col_name"), element.getString("col_data_type"), element.getString("col_desc")))).toMap
    } else {
      Map[String, ResultSchema]()
    }
    resultSchema -= ""
    resultSchema += (colName -> new ResultSchema(colName, colDataType, colDesc))
    val jsonStr = resultSchema.values.toArray.map(element => JSONUtils.object2JsonString(element))
    scrawConfigTmp.setScrawResultSchema(s"[${jsonStr.mkString(",")}]")
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
      .toArray.map(element => (element.getColName, element)).toMap
    resultSchemaMap -= colName
    val jsonStr = JSONUtils.object2JsonString(resultSchemaMap.values.toArray)
    scrawConfig.setScrawResultSchema(jsonStr)
    scrawConfigMapper.updateByPrimaryKey(scrawConfig) > 1
  }

  def updateScrawBaseConfig(scrawId: Integer, scrawUrl: String, scrawPersistType: String, scrawDbname: String, scrawTableName: String): Boolean = {
    val scrawConfig = scrawConfigMapper.selectByPrimaryKey(scrawId)
    scrawConfig.setScrawBaseUrl(scrawUrl)
    if (scrawConfig.getScawPersistConfig.isNullEmptyTrim || (!scrawConfig.getScawPersistConfig.trim.startsWith("{") && !scrawConfig.getScawPersistConfig.trim.startsWith("}"))) {
      scrawConfig.setScawPersistConfig(s"""{"scraw_persist_type":"${scrawPersistType}","scraw_db_name":"${scrawDbname}","scraw_table_name":"${scrawTableName}"}""")
    } else {
      val persistConfigJson = JSON.parseObject(scrawConfig.getScawPersistConfig)
      if (scrawPersistType.isNotNullEmptyTrim) {
        persistConfigJson.put("scraw_persist_type", scrawPersistType)
      }
      if (scrawDbname.isNotNullEmptyTrim) {
        persistConfigJson.put("scraw_db_name", scrawDbname)
      }
      if (scrawTableName.isNotNullEmptyTrim) {
        persistConfigJson.put("scraw_table_name", scrawTableName)
      }
      scrawConfig.setScawPersistConfig(persistConfigJson.toJSONString)
    }
    scrawConfigMapper.updateByPrimaryKey(scrawConfig) > 0
  }
}
