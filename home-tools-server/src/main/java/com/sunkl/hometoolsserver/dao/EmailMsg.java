package com.sunkl.hometoolsserver.dao;

public class EmailMsg {
    private Integer emailMsgId;

    private String srcAddress;

    private String targetAddress;

    private String emailObject;

    private String emailMsg;

    private String isSend;

    private String sendTime;

    private String createTime;

    private String updateTime;

    public Integer getEmailMsgId() {
        return emailMsgId;
    }

    public void setEmailMsgId(Integer emailMsgId) {
        this.emailMsgId = emailMsgId;
    }

    public String getSrcAddress() {
        return srcAddress;
    }

    public void setSrcAddress(String srcAddress) {
        this.srcAddress = srcAddress == null ? null : srcAddress.trim();
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(String targetAddress) {
        this.targetAddress = targetAddress == null ? null : targetAddress.trim();
    }

    public String getEmailObject() {
        return emailObject;
    }

    public void setEmailObject(String emailObject) {
        this.emailObject = emailObject == null ? null : emailObject.trim();
    }

    public String getEmailMsg() {
        return emailMsg;
    }

    public void setEmailMsg(String emailMsg) {
        this.emailMsg = emailMsg == null ? null : emailMsg.trim();
    }

    public String getIsSend() {
        return isSend;
    }

    public void setIsSend(String isSend) {
        this.isSend = isSend == null ? null : isSend.trim();
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
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