package com.sunkl.hometoolsserver.dao;

public class FamilyUser {
    public FamilyUser() {
    }

    public FamilyUser(String userName, String passwd, String userRole, String userAuth, String niceName, String phone, String birthDay, String createTime, String updateTime) {
        this.userName = userName;
        this.passwd = passwd;
        this.userRole = userRole;
        this.userAuth = userAuth;
        this.niceName = niceName;
        this.phone = phone;
        this.birthDay = birthDay;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    private Integer userId;

    private String userName;

    private String passwd;

    private String userRole;

    private String userAuth;

    private String niceName;

    private String phone;

    private String birthDay;

    private String createTime;

    private String updateTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    public String getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(String userAuth) {
        this.userAuth = userAuth == null ? null : userAuth.trim();
    }

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName == null ? null : niceName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay == null ? null : birthDay.trim();
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