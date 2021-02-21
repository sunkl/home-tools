package com.sunkl.hometoolsserver.dao.email.html

case class HTMLScrpt() {
  private[this] var tables = Map[Int, HtmlTable]()
  private var index = 1;

  def addTable(table: HtmlTable): Unit = {
    tables += (index -> table)
    index += 1;
  }

  def addTable(title: Array[String], data: Array[Array[String]]): Unit = {
    val table = new HtmlTable(title, data, 2)
    this.addTable(table)
  }
}
