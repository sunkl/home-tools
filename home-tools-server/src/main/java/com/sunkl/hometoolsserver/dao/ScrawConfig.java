package com.sunkl.hometoolsserver.dao;

import com.sunkl.hometoolsserver.utils.TimeUtils;

import java.sql.Time;

public class ScrawConfig {
    private Integer scrawId;

    private String scrawName;

    private String scrawDesc;

    private String scrawBaseUrl;

    private String scrawParams;

    private String scrawResultSchema;

    private String scawPersistConfig;
    private String scrawActionStartTime;
    private String actionFrequencyNum;
    private String actionFrequencyUnit;
    private String createTime;

    private String updateTime;

    public Integer getScrawId() {
        return scrawId;
    }

    public void setScrawId(Integer scrawId) {
        this.scrawId = scrawId;
    }

    public String getScrawName() {
        return scrawName;
    }

    public void setScrawName(String scrawName) {
        this.scrawName = scrawName == null ? null : scrawName.trim();
    }

    public String getScrawDesc() {
        return scrawDesc;
    }

    public void setScrawDesc(String scrawDesc) {
        this.scrawDesc = scrawDesc == null ? null : scrawDesc.trim();
    }

    public String getScrawBaseUrl() {
        return scrawBaseUrl;
    }

    public void setScrawBaseUrl(String scrawBaseUrl) {
        this.scrawBaseUrl = scrawBaseUrl == null ? null : scrawBaseUrl.trim();
    }

    public String getScrawParams() {
        return scrawParams;
    }

    public void setScrawParams(String scrawParams) {
        this.scrawParams = scrawParams == null ? null : scrawParams.trim();
    }

    public String getScrawResultSchema() {
        return scrawResultSchema;
    }

    public void setScrawResultSchema(String scrawResultSchema) {
        this.scrawResultSchema = scrawResultSchema == null ? null : scrawResultSchema.trim();
    }

    public String getScawPersistConfig() {
        return scawPersistConfig;
    }

    public void setScawPersistConfig(String scawPersistConfig) {
        this.scawPersistConfig = scawPersistConfig == null ? null : scawPersistConfig.trim();
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

    public String getScrawActionStartTime() {
        return scrawActionStartTime;
    }

    public void setScrawActionStartTime(String scrawActionStartTime) {
        this.scrawActionStartTime = scrawActionStartTime;
    }

    public String getActionFrequencyNum() {
        return actionFrequencyNum;
    }

    public void setActionFrequencyNum(String actionFrequencyNum) {
        this.actionFrequencyNum = actionFrequencyNum;
    }

    public String getActionFrequencyUnit() {
        return actionFrequencyUnit;
    }

    public void setActionFrequencyUnit(String actionFrequencyUnit) {
        this.actionFrequencyUnit = actionFrequencyUnit;
    }

    public ScrawConfig(String scrawName) {
        this.scrawName = scrawName;
        this.scrawParams = "[]";
        this.scrawResultSchema = "[]";
        this.scawPersistConfig = "{}";
        this.createTime = TimeUtils.getCurrentDateTime();
        this.updateTime = TimeUtils.getCurrentDateTime();
    }

    public ScrawConfig(String scrawName, String scrawDesc, String scrawBaseUrl, String scrawParams, String scrawResultSchema, String scawPersistConfig, String scrawActionStartTime, String actionFrequencyNum, String actionFrequencyUnit) {
        this.scrawName = scrawName;
        this.scrawDesc = scrawDesc;
        this.scrawBaseUrl = scrawBaseUrl;
        this.scrawParams = scrawParams;
        this.scrawResultSchema = scrawResultSchema;
        this.scawPersistConfig = scawPersistConfig;
        this.scrawActionStartTime = scrawActionStartTime;
        this.actionFrequencyNum = actionFrequencyNum;
        this.actionFrequencyUnit = actionFrequencyUnit;
        this.createTime = TimeUtils.getCurrentDateTime();
        this.updateTime = TimeUtils.getCurrentDateTime();
    }

    public ScrawConfig(Integer scrawId, String scrawName, String scrawDesc, String scrawBaseUrl, String scrawParams, String scrawResultSchema, String scawPersistConfig, String scrawActionStartTime, String actionFrequencyNum, String actionFrequencyUnit) {
        this.scrawId = scrawId;
        this.scrawName = scrawName;
        this.scrawDesc = scrawDesc;
        this.scrawBaseUrl = scrawBaseUrl;
        this.scrawParams = scrawParams;
        this.scrawResultSchema = scrawResultSchema;
        this.scawPersistConfig = scawPersistConfig;
        this.scrawActionStartTime = scrawActionStartTime;
        this.actionFrequencyNum = actionFrequencyNum;
        this.actionFrequencyUnit = actionFrequencyUnit;
        this.createTime = TimeUtils.getCurrentDateTime();
        this.updateTime = TimeUtils.getCurrentDateTime();
    }

    public ScrawConfig(Integer scrawId, String scrawName, String scrawDesc, String scrawBaseUrl, String scrawParams, String scrawResultSchema, String scawPersistConfig, String scrawActionStartTime, String actionFrequencyNum, String actionFrequencyUnit, String createTime, String updateTime) {
        this.scrawId = scrawId;
        this.scrawName = scrawName;
        this.scrawDesc = scrawDesc;
        this.scrawBaseUrl = scrawBaseUrl;
        this.scrawParams = scrawParams;
        this.scrawResultSchema = scrawResultSchema;
        this.scawPersistConfig = scawPersistConfig;
        this.scrawActionStartTime = scrawActionStartTime;
        this.actionFrequencyNum = actionFrequencyNum;
        this.actionFrequencyUnit = actionFrequencyUnit;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}