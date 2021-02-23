package com.sunkl.hometoolsserver.service

import com.sunkl.hometoolsserver.dao.StockHolderChange
import com.sunkl.hometoolsserver.dao.email.html.HtmlTable
import com.sunkl.hometoolsserver.mapper.StockHolderChangeMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.sunkl.hometoolsserver.utils.UdImplict._

import java.util
import java.util.{Arrays, List}
import collection.JavaConverters._

@Service
class StockHolderChangeService @Autowired()(
                                             val stockHolderChangeMapper: StockHolderChangeMapper
                                           ) {
  val tableTitle: String = "大股东持股变更"

  def getColName(): Array[String] = {
    Array(
      "股票",
      "公司",
      "收盘价",
      "涨跌幅",
      "持股人",
      "增减",
      "变动股数",
      "变动后占流通比例",
      "变动后股数",
      "市场级别",
      "变动开始",
      "变动结束",
      "公告日期")

  }

  def getValueArray(stockHolderChange: StockHolderChange) = {
    Array(
      stockHolderChange.getCompanyCode,
      stockHolderChange.getSname,
      stockHolderChange.getClose + "",
      stockHolderChange.getChangePercent + "",
      stockHolderChange.getShareHdName,
      stockHolderChange.getIncreaseOrDecrease,
      stockHolderChange.getChangeNum + "",
      stockHolderChange.getProportionInCirculatingShares + "",
      stockHolderChange.getRatioOfTotalEquityAfterChange + "",
      stockHolderChange.getMarketLevel,
      stockHolderChange.getChangeStartDate,
      stockHolderChange.getChangeEndDate,
      stockHolderChange.getNoticeDate)

  }

  def selectByStockCodeAndDate(stockCodes: Array[String], date: String): Array[StockHolderChange] = {
    stockHolderChangeMapper.selectByCondition(
      s"""
         |scode in (${stockCodes.map(stockCode => s"'${stockCode}'").mkString(",")})
         |and notice_date='${date}'
         |""".stripMargin).asScala.toArray
  }

  def selectByStockCodeAndDateAndToTabelHtml(stockCodes: Array[String], date: String): HtmlTable = {
    val stockHolderChanges = this.selectByStockCodeAndDate(stockCodes, date).map(shc => this.getValueArray(shc))
    new HtmlTable(this.getColName(), stockHolderChanges, tableTitle)
  }
}
