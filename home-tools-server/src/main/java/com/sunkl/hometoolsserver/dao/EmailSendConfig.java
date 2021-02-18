package com.sunkl.hometoolsserver.dao;

public class EmailSendConfig {
    private Integer emailSendConfigId;

    private Integer userId;

    private String itemType;

    private String condition;

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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition == null ? null : condition.trim();
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
}