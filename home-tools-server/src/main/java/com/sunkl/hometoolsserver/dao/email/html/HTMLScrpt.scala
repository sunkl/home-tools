package com.sunkl.hometoolsserver.dao.email.html

import com.sunkl.hometoolsserver.dao.FamilyUser

case class HTMLScrpt(familyUser: FamilyUser) {
  private[this] var tables = Map[Int, HtmlTable]()
  private var index = 1;

  def addTable(table: HtmlTable): Unit = {
    tables += (index -> table)
    index += 1;
  }

  def addTable(title: String, tableColName: Array[String], data: Array[Array[String]]): HTMLScrpt = {
    val table = new HtmlTable(tableColName, data, title, 2)
    this.addTable(table)
    this
  }

  def bodyScript(): String = {
    if (index >= 1) {
      (1 until index).map(tmp => tables(tmp).toHtml()).mkString("\n")
    } else {
      ""
    }
  }

  def toHtmlScript(): String = {
    s"""
       |<html>
       |  <body>
       |   尊敬的${familyUser.getNiceName}:
       |  <p>&nbsp;&nbsp;&nbsp;&nbsp;今日股票消息速递</p>
       |  ${bodyScript()}
       |  </body>
       |</html>
       |""".stripMargin
  }
}
