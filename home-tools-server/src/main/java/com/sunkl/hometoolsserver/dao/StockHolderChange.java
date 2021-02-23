package com.sunkl.hometoolsserver.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockHolderChange {
    private String shcode;

    private String companyCode;

    private String scode;

    private String close;

    private String changePercent;

    private String sname;

    private String shareHdName;

    private String increaseOrDecrease;

    private String changeNum;

    private String proportionInCirculatingShares;

    private String marketLevel;

    private String totalShareholdingAfterChange;

    private String ratioOfTotalEquityAfterChange;

    private String numSharesInCirculationAfterChange;

    private String proportionCirculatingSharesAfterChange;

    private String changeStartDate;

    private String changeEndDate;

    private String noticeDate;

    private String proportionInTotalShareCapital;


    public String getShcode() {
        return shcode;
    }

    public void setShcode(String shcode) {
        this.shcode = shcode == null ? null : shcode.trim();
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode == null ? null : scode.trim();
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close == null ? null : close.trim();
    }

    public String getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent == null ? null : changePercent.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getShareHdName() {
        return shareHdName;
    }

    public void setShareHdName(String shareHdName) {
        this.shareHdName = shareHdName == null ? null : shareHdName.trim();
    }

    public String getIncreaseOrDecrease() {
        return increaseOrDecrease;
    }

    public void setIncreaseOrDecrease(String increaseOrDecrease) {
        this.increaseOrDecrease = increaseOrDecrease == null ? null : increaseOrDecrease.trim();
    }

    public String getChangeNum() {
        return changeNum;
    }

    public void setChangeNum(String changeNum) {
        this.changeNum = changeNum == null ? null : changeNum.trim();
    }

    public String getProportionInCirculatingShares() {
        return proportionInCirculatingShares;
    }

    public void setProportionInCirculatingShares(String proportionInCirculatingShares) {
        this.proportionInCirculatingShares = proportionInCirculatingShares == null ? null : proportionInCirculatingShares.trim();
    }

    public String getMarketLevel() {
        return marketLevel;
    }

    public void setMarketLevel(String marketLevel) {
        this.marketLevel = marketLevel == null ? null : marketLevel.trim();
    }

    public String getTotalShareholdingAfterChange() {
        return totalShareholdingAfterChange;
    }

    public void setTotalShareholdingAfterChange(String totalShareholdingAfterChange) {
        this.totalShareholdingAfterChange = totalShareholdingAfterChange == null ? null : totalShareholdingAfterChange.trim();
    }

    public String getRatioOfTotalEquityAfterChange() {
        return ratioOfTotalEquityAfterChange;
    }

    public void setRatioOfTotalEquityAfterChange(String ratioOfTotalEquityAfterChange) {
        this.ratioOfTotalEquityAfterChange = ratioOfTotalEquityAfterChange == null ? null : ratioOfTotalEquityAfterChange.trim();
    }

    public String getNumSharesInCirculationAfterChange() {
        return numSharesInCirculationAfterChange;
    }

    public void setNumSharesInCirculationAfterChange(String numSharesInCirculationAfterChange) {
        this.numSharesInCirculationAfterChange = numSharesInCirculationAfterChange == null ? null : numSharesInCirculationAfterChange.trim();
    }

    public String getProportionCirculatingSharesAfterChange() {
        return proportionCirculatingSharesAfterChange;
    }

    public void setProportionCirculatingSharesAfterChange(String proportionCirculatingSharesAfterChange) {
        this.proportionCirculatingSharesAfterChange = proportionCirculatingSharesAfterChange == null ? null : proportionCirculatingSharesAfterChange.trim();
    }

    public String getChangeStartDate() {
        return changeStartDate;
    }

    public void setChangeStartDate(String changeStartDate) {
        this.changeStartDate = changeStartDate == null ? null : changeStartDate.trim();
    }

    public String getChangeEndDate() {
        return changeEndDate;
    }

    public void setChangeEndDate(String changeEndDate) {
        this.changeEndDate = changeEndDate == null ? null : changeEndDate.trim();
    }

    public String getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(String noticeDate) {
        this.noticeDate = noticeDate == null ? null : noticeDate.trim();
    }

    public String getProportionInTotalShareCapital() {
        return proportionInTotalShareCapital;
    }

    public void setProportionInTotalShareCapital(String proportionInTotalShareCapital) {
        this.proportionInTotalShareCapital = proportionInTotalShareCapital == null ? null : proportionInTotalShareCapital.trim();
    }

}