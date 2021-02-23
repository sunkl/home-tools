package com.sunkl.hometoolsserver.dao;

public class SchulerTaskConfig {
    private Integer taskId;

    private String taskName;

    private String cornConfig;

    private String createTime;

    private String updateTime;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getCornConfig() {
        return cornConfig;
    }

    public void setCornConfig(String cornConfig) {
        this.cornConfig = cornConfig == null ? null : cornConfig.trim();
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