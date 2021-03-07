package com.sunkl.hometoolsserver.dao;

public class ScrawConfig {
    private Integer scrawId;

    private String scrawName;

    private String scrawDesc;

    private String scrawBaseUrl;

    private String scrawParams;

    private String scrawResultSchema;

    private String scawPersistConfig;

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
}