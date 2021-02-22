package com.sunkl.hometoolsserver.dao.email.html

import com.sunkl.hometoolsserver.utils.HtmlUtils
import com.sunkl.hometoolsserver.utils.UdImplict._

import java.io

class HtmlTable(
                 var tableColName: Array[String],
                 var tableBody: Array[Array[String]],
                 var title: String,
                 var step: Int
               ) {

  def toHtml(): String = {
    val tableSpace = " ".repeatNum(step * HtmlUtils.spaceNumPerStemp)
    val trSpace = " ".repeatNum((step + 1) * HtmlUtils.spaceNumPerStemp)
    val tdOrThSpace = " ".repeatNum((step + 2) * HtmlUtils.spaceNumPerStemp)
    val ths = this.tableColName.map(th => s"${tdOrThSpace}<th>${th}</th>").mkString("\n")
    val tableData = this.tableBody.map(row => {
      val cols = row.map(col => s"\n${tdOrThSpace}<td>${col}</td>").mkString("")
      s"\n${trSpace}<tr  bgcolor='#E0E0E0'>${cols}\n${trSpace}<tr>"
    }).mkString("")

    s"""
       |<p>
       |<b>${title}</b>
       |</hr>
       |${tableSpace}<table width='800px'>
       |${trSpace}<tr  bgcolor="#8E8E8E">
       |${ths}
       |${trSpace}</tr>
       |${tableData}
       |${tableSpace}</table>
       |</p>
       |""".stripMargin
  }
}

object Test {
  //  def main(args: Array[String]): Unit = {
  //    val table = new HtmlTable(Array("股票代码", "公司名称", "职务", "持股人姓名", "增减", "变动股票(万股)", "变动金额（万元）"),
  //      Array(
  //        Array("100001", "中国平安", "财务总监", "牛焕青", "增持", "10000.00", "400000000.00"),
  //        Array("100001", "中国平安", "财务总监", "孙昆仑", "增持", "10000.00", "400000000.00")
  //      ), 0
  //    )
  //    println(table.toHtml())
  //    //    print("ha".swapHtml("tr").swapHtml("td",2,true).swapHtml("table",1,true))
  //  }
  //
  //  def testStr(): String = {
  //    new HtmlTable(Array("股票代码", "公司名称", "职务", "持股人姓名", "增减", "变动股票(万股)", "变动金额（万元）"),
  //      Array(
  //        Array("100001", "中国平安", "财务总监", "牛焕青", "增持", "10000.00", "400000000.00"),
  //        Array("100001", "中国平安", "财务总监", "孙昆仑", "增持", "10000.00", "400000000.00")
  //      ), 0
  //    ).toHtml()
  //  }
}