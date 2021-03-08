package com.sunkl.hometoolsserver.dao;

public class ResultSchema {
    private String colName;
    private String colDataType;
    private String colDesc;

    public ResultSchema(String colName, String colDataType, String colDesc) {
        this.colName = colName;
        this.colDataType = colDataType;
        this.colDesc = colDesc;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColDataType() {
        return colDataType;
    }

    public void setColDataType(String colDataType) {
        this.colDataType = colDataType;
    }

    public String getColDesc() {
        return colDesc;
    }

    public void setColDesc(String colDesc) {
        this.colDesc = colDesc;
    }
}
