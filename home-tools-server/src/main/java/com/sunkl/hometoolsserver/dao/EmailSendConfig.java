package com.sunkl.hometoolsserver.dao;

import java.util.Arrays;

public class EmailSendConfig {

    private Integer emailSendConfigId;

    private Integer userId;

    private String itemType;

    private String conditionStr;

    private String dateRange;

    private String dateRangeColName;

    private String itemMessage;

    private String createTime;

    private String updateTime;

    public Integer getEmailSendConfigId() {
        return emailSendConfigId;
    }

    public void setEmailSendConfigId(Integer emailSendConfigId) {
        this.emailSendConfigId = emailSendConfigId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public boolean upsertItemMsg(String stockCode) {
        if (this.getItemMessage() == null || this.getItemMessage().trim().isEmpty()) {
            this.setItemMessage(stockCode);
            return true;
        } else if (!Arrays.asList(this.getItemMessage().split(",")).contains(stockCode)) {
            this.setItemMessage(this.getItemMessage() + "," + stockCode);
            return true;
        } else {
            return false;
        }
    }

    public String getConditionStr() {
        return conditionStr;
    }

    public void setConditionStr(String conditionStr) {
        this.conditionStr = conditionStr == null ? null : conditionStr.trim();
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange == null ? null : dateRange.trim();
    }

    public String getDateRangeColName() {
        return dateRangeColName;
    }

    public void setDateRangeColName(String dateRangeColName) {
        this.dateRangeColName = dateRangeColName == null ? null : dateRangeColName.trim();
    }

    public String getItemMessage() {
        return itemMessage;
    }

    public void setItemMessage(String itemMessage) {
        this.itemMessage = itemMessage == null ? null : itemMessage.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public EmailSendConfig(Integer emailSendConfigId, Integer userId, String itemType, String condition, String dateRange, String dateRangeColName, String itemMessage, String createTime, String updateTime) {
        this.emailSendConfigId = emailSendConfigId;
        this.userId = userId;
        this.itemType = itemType;
        this.conditionStr = condition;
        this.dateRange = dateRange;
        this.dateRangeColName = dateRangeColName;
        this.itemMessage = itemMessage;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}