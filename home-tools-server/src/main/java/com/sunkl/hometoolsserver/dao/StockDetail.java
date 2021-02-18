package com.sunkl.hometoolsserver.dao;

public class StockDetail {
    private Integer stockDetailId;

    private String stockCode;

    private String stockName;

    private String createTime;

    public Integer getStockDetailId() {
        return stockDetailId;
    }

    public void setStockDetailId(Integer stockDetailId) {
        this.stockDetailId = stockDetailId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName == null ? null : stockName.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}