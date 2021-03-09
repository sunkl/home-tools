package com.sunkl.hometoolsserver.service

import com.alibaba.fastjson.{JSON, JSONArray, JSONObject}
import com.sunkl.hometoolsserver.dao.{ResultSchema, ScrawConfig}
import com.sunkl.hometoolsserver.mapper.ScrawConfigMapper
import com.sunkl.hometoolsserver.utils.{JSONUtils, TimeUtils}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import collection.JavaConverters._
import com.sunkl.hometoolsserver.utils.UdImplict._

@Service
class ScrawConfigService @Autowired()(val scrawConfigMapper: ScrawConfigMapper) {
  def createScraw(scrawConfig: ScrawConfig): String = {
    val isNotExist = scrawConfigMapper.selectByCondition(s"scraw_name='${scrawConfig.getScrawName}'").size() == 0
    val isSucess = if (isNotExist) {
      scrawConfigMapper.insert(scrawConfig) > 0
    } else {
      false
    }
    isSucess.toString
  }

  def deleteById(id: Integer): Boolean = {
    scrawConfigMapper.deleteByPrimaryKey(id) > 0
  }

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
    scrawConfigMapper.selectByPrimaryKey(id)
  }

  def selectByScrawName(name: String): ScrawConfig = {
    scrawConfigMapper.selectByCondition(s"scraw_name='${name}'").asScala.head
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
      var jSONObjectMap: Map[String, JSONObject] = jsonArr.toArray(Array[JSONObject]())
        .map(element => (element.getString("param_name"), element))
        .toMap
      jSONObjectMap += (paramName -> JSON.parseObject(s"""{"param_name":"${paramName}","param_value":"${paramValue}","param_index":"${jSONObjectMap.size}"}"""))
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
  def addReusltCol(scrawConfigId: Integer, colName: String, colDataType: String, colDesc: String): Boolean = {
    val scrawConfigTmp = scrawConfigMapper.selectByPrimaryKey(scrawConfigId)
    //    var resultSchema: Map[String, ResultSchema] = if (scrawConfigTmp.getScrawResultSchema.isNotNullEmptyTrim) {
    //      JSON.parseArray(scrawConfigTmp.getScrawResultSchema)
    //        .toArray(Array[JSONObject]())
    //        .map(element => (element.getString("col_name"), new ResultSchema(element.getString("col_name"), element.getString("col_data_type"), element.getString("col_desc")))).toMap
    //    } else {
    //      Map[String, ResultSchema]()
    //    }
    //    resultSchema += (colName -> new ResultSchema(colName, colDataType, colDesc))
    //    val jsonStr = resultSchema.values.toArray.map(element => JSONUtils.object2JsonString(element))
    //    scrawConfigTmp.setScrawResultSchema(s"[${jsonStr.mkString(",")}]")
    val cols = JSON.parseArray(scrawConfigTmp.getScrawResultSchema)
    cols.toArray(Array[JSONObject]()).exists(_.getString("col_name").equals(colName)) match {
      case false =>
        val newTmp = new JSONObject()
        newTmp.put("col_index", cols.size())
        newTmp.put("col_name", colName)
        newTmp.put("col_data_type", colDataType)
        newTmp.put("col_desc", colDesc)
        cols.add(newTmp)
        scrawConfigTmp.setScrawResultSchema(JSONUtils.object2JsonString(cols))
        scrawConfigMapper.updateByPrimaryKey(scrawConfigTmp) > 1
      case _ => false
    }

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

  def updateScrawBaseConfig(scrawConfigNew: ScrawConfig): Boolean = {
    val scrawConfig = scrawConfigMapper.selectByPrimaryKey(scrawConfigNew.getScrawId)
    scrawConfig.setScrawBaseUrl(scrawConfigNew.getScrawBaseUrl)
    scrawConfig.setScawPersistConfig(scrawConfigNew.getScawPersistConfig)
    scrawConfig.setScrawDesc(scrawConfigNew.getScrawDesc)
    scrawConfig.setScrawName(scrawConfigNew.getScrawName)
    scrawConfig.setUpdateTime(TimeUtils.getCurrentDateTime)
    scrawConfig.setScrawActionStartTime(scrawConfigNew.getScrawActionStartTime)
    scrawConfig.setActionFrequencyNum(scrawConfigNew.getActionFrequencyNum)
    scrawConfig.setActionFrequencyUnit(scrawConfigNew.getActionFrequencyUnit)
    /*    if (scrawConfig.getScawPersistConfig.isNullEmptyTrim || (!scrawConfig.getScawPersistConfig.trim.startsWith("{") && !scrawConfig.getScawPersistConfig.trim.startsWith("}"))) {
          scrawConfig.setScawPersistConfig(scrawConfig.getScawPersistConfig)
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
        }*/
    scrawConfigMapper.updateByPrimaryKey(scrawConfig) > 0
  }

  def updateResultColPram(scrawId: Integer, colIndex: Int, colParamValue: String, colParameType: String): Unit = {
    val scrawConfig = scrawConfigMapper.selectByPrimaryKey(scrawId)
    var resultSchemaJsonMap: Map[Int, JSONObject] = JSON.parseArray(scrawConfig.getScrawResultSchema)
      .toArray(Array[JSONObject]())
      .map(element => (element.getIntValue("col_index"), element))
      .toMap
    resultSchemaJsonMap.get(colIndex) match {
      case Some(colJson) =>
        colParameType.trim.toLowerCase() match {
          case "col_name" =>
            colJson.put("col_name", colParamValue)
          case "col_data_type" =>
            colJson.put("col_data_type", colParamValue)
          case "col_desc" =>
            colJson.put("col_data_type", colParamValue)
          case "move_up" =>
            resultSchemaJsonMap.get(colIndex - 1) match {
              case Some(beforJson) =>
                beforJson.put("col_index", colIndex)
                val curentJson = resultSchemaJsonMap(colIndex)
                curentJson.put("col_index", colIndex - 1)
                resultSchemaJsonMap += (colIndex - 1 -> curentJson)
                resultSchemaJsonMap += (colIndex -> beforJson)
              case None =>
            }
          case "move_down" =>
            resultSchemaJsonMap.get(colIndex + 1) match {
              case Some(nextJson) =>
                nextJson.put("col_index", colIndex)
                val curentJson = resultSchemaJsonMap(colIndex)
                curentJson.put("col_index", colIndex + 1)
                resultSchemaJsonMap += (colIndex + 1 -> curentJson)
                resultSchemaJsonMap += (colIndex -> nextJson)
              case None =>
            }
          case "col_delete" =>
            resultSchemaJsonMap -= scrawId
            resultSchemaJsonMap = resultSchemaJsonMap.map { case (colIndexTmp, json) =>
              if (colIndexTmp > colIndex) {
                json.put("col_index", colIndexTmp - 1)
                (colIndexTmp - 1, json)
              } else {
                (colIndexTmp, json)
              }
            }
          case _ =>
            require(false, s"不支持的colParamType[${colParameType}]")
        }
      case None =>
    }
    val arrJson = resultSchemaJsonMap.values
      .toArray
      .sortBy(_.getIntValue("col_index"))
      .map(ele => JSONUtils.object2JsonString(ele)).mkString(",")
    scrawConfig.setScrawResultSchema(s"[${arrJson}]")
    scrawConfigMapper.updateByPrimaryKey(scrawConfig)
  }

  def updateUrlParam(scrawId: Integer, paramIndex: Int, paramValue: String, updateType: String): Unit = {
    val scrawConfig = scrawConfigMapper.selectByPrimaryKey(scrawId)
    val jsonArr = JSON.parseArray(scrawConfig.getScrawParams)
    var paramMap = jsonArr.toArray(Array[JSONObject]())
      .map(elment => (elment.getIntValue("param_index"), elment))
      .toMap
    paramMap.get(paramIndex) match {
      case Some(paramJson) =>
        updateType.trim.toLowerCase() match {
          case "param_name" =>
            paramJson.put("param_name", paramValue)
          case "param_value" =>
            paramJson.put("param_value", paramValue)
          case "param_delete" =>
            paramMap -= paramIndex
            paramMap = paramMap.map { case (index, json) =>
              if (index > paramIndex) {
                json.put("param_index", paramJson.getIntValue("param_index") - 1)
                (index - 1, json)
              } else {
                (index, json)
              }
            }
          case _ =>
        }
      case None =>
    }
    scrawConfig.setScrawParams(jsonArr.toJSONString)
    scrawConfigMapper.updateByPrimaryKey(scrawConfig)
  }
}
