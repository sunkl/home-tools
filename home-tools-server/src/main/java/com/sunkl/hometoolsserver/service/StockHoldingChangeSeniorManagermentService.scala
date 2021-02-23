package com.sunkl.hometoolsserver.service

import com.sunkl.hometoolsserver.dao.StockHoldingChangeSeniorManagerment
import com.sunkl.hometoolsserver.dao.email.html.HtmlTable
import com.sunkl.hometoolsserver.mapper.StockHoldingChangeSeniorManagermentMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConverters._

@Service
class StockHoldingChangeSeniorManagermentService @Autowired()(
                                                               val stockHoldingChangeSeniorManagermentMapper: StockHoldingChangeSeniorManagermentMapper
                                                             ) {
  val tableTitle: String = "大股东持股变更"

  def getColName(): Array[String] = {
    Array(
      "股票代码",
      "董监高人员姓名",
      "持股种类",
      "变更比例",
      "变动股数",
      "变动后持股数",
      "成交均价",
      "变动金额",
      "变动原因",
      "职务",
      "变动人与董监高的关系",
      "日期"
    )
  }

  def getColValue(config: StockHoldingChangeSeniorManagerment): Array[String] = {
    Array(
      config.getStockCode,
      config.getHolderName,
      config.getStockHoldType,
      config.getChangeRatio,
      config.getNumOfChangedShares,
      config.getNumShareAferChange,
      config.getAverageTransactionPrice,
      config.getChangeAmount,
      config.getReasonOfChange,
      config.getJob,
      config.getRelationshipBetweenSeniorManager,
      config.getChangeDate
    )
  }

  def selectByStockCodeAndDate(stockCodes: Array[String], date: String): Array[StockHoldingChangeSeniorManagerment] = {
    stockHoldingChangeSeniorManagermentMapper.selectSCSMByCondition(
      s"""
         |stock_code in (${stockCodes.map(stockCode => s"'${stockCode}'").mkString(",")})
         |and change_date='${date}'
         |""".stripMargin).asScala.toArray
  }

  def selectByStockCodeAndDateToHtmlTable(stockCodes: Array[String], date: String) = {
    val stockHoldingChangeSeniorManagerments = this.selectByStockCodeAndDate(stockCodes, date).map(config => this.getColValue(config))
    new HtmlTable(this.getColName(), stockHoldingChangeSeniorManagerments, tableTitle)

  }
}
