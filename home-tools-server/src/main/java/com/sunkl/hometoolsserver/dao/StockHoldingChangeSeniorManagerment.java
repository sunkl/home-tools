package com.sunkl.hometoolsserver.dao;

public class StockHoldingChangeSeniorManagerment {
    private String changeRatio;

    private String holderName;

    private String stockCode;

    private String changePerson;

    private String stockHoldType;

    private String changeDate;

    private String numShareAferChange;

    private String numOfChangedShares;

    private String averageTransactionPrice;

    private String name;

    private String relationshipBetweenSeniorManager;

    private String reasonOfChange;

    private String changeAmount;

    private String job;

    public String getChangeRatio() {
        return changeRatio;
    }

    public void setChangeRatio(String changeRatio) {
        this.changeRatio = changeRatio == null ? null : changeRatio.trim();
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName == null ? null : holderName.trim();
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public String getChangePerson() {
        return changePerson;
    }

    public void setChangePerson(String changePerson) {
        this.changePerson = changePerson == null ? null : changePerson.trim();
    }

    public String getStockHoldType() {
        return stockHoldType;
    }

    public void setStockHoldType(String stockHoldType) {
        this.stockHoldType = stockHoldType == null ? null : stockHoldType.trim();
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate == null ? null : changeDate.trim();
    }

    public String getNumShareAferChange() {
        return numShareAferChange;
    }

    public void setNumShareAferChange(String numShareAferChange) {
        this.numShareAferChange = numShareAferChange == null ? null : numShareAferChange.trim();
    }

    public String getNumOfChangedShares() {
        return numOfChangedShares;
    }

    public void setNumOfChangedShares(String numOfChangedShares) {
        this.numOfChangedShares = numOfChangedShares == null ? null : numOfChangedShares.trim();
    }

    public String getAverageTransactionPrice() {
        return averageTransactionPrice;
    }

    public void setAverageTransactionPrice(String averageTransactionPrice) {
        this.averageTransactionPrice = averageTransactionPrice == null ? null : averageTransactionPrice.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRelationshipBetweenSeniorManager() {
        return relationshipBetweenSeniorManager;
    }

    public void setRelationshipBetweenSeniorManager(String relationshipBetweenSeniorManager) {
        this.relationshipBetweenSeniorManager = relationshipBetweenSeniorManager == null ? null : relationshipBetweenSeniorManager.trim();
    }

    public String getReasonOfChange() {
        return reasonOfChange;
    }

    public void setReasonOfChange(String reasonOfChange) {
        this.reasonOfChange = reasonOfChange == null ? null : reasonOfChange.trim();
    }

    public String getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(String changeAmount) {
        this.changeAmount = changeAmount == null ? null : changeAmount.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }
}