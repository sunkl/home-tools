package com.sunkl.hometoolsserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sunkl.hometoolsserver.dao.EmailSendConfig;
import com.sunkl.hometoolsserver.dao.StockDetail;
import com.sunkl.hometoolsserver.service.EmailSendConfigService;
import com.sunkl.hometoolsserver.service.StockDetailService;
import com.sunkl.hometoolsserver.utils.JSONUtils;
import com.sunkl.hometoolsserver.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/family_user")
public class EmailSendConfigController {
    @Autowired
    EmailSendConfigService emailSendConfigService;
    @Autowired
    StockDetailService stockDetailService;

    @CrossOrigin
    @GetMapping("/setting/emailSendConfig/queryItemMsgByUserIdItemType")
    public String queryItemMsgByUserIdItemType(@RequestParam("user_id") String userId, @RequestParam("item_type") String itemType) {
        List<EmailSendConfig> emailSendConfigs = emailSendConfigService.selectByUserIdAndItemType(userId, itemType);
        if (emailSendConfigs.isEmpty()) {
            return "";
        } else {
            return emailSendConfigs.get(0).getItemMessage();
        }
    }

    @CrossOrigin
    @GetMapping("/setting/emailSendConfig/updateEmailSendBaseConfig")
    public String updateEmailSendBaseConfig(@RequestParam("user_id") String userId, @RequestParam("item_type") String itemType, @RequestParam("item_msg") String itemMsg) {
        emailSendConfigService.upsertBaseConfig(userId, itemType, itemMsg);
        List<EmailSendConfig> emailSendConfigs = emailSendConfigService.selectByUserIdAndItemType(userId, itemType);
        if (emailSendConfigs.isEmpty()) {
            return "";
        } else {
            return emailSendConfigs.get(0).getItemMessage();
        }
    }

    @CrossOrigin
    @GetMapping("/setting/emailSendConfig/updateStockCodeItemSwitch")
    public String updateStockCodeItemSwitch(
            @RequestParam("user_id") String userId,
            @RequestParam("stock_code") String stockCode,
            @RequestParam("item_type") String itemType,
            @RequestParam("switch_value") Boolean switchValue) throws JsonProcessingException {
        List<EmailSendConfig> emailSendConfigs = emailSendConfigService.selectByUserIdAndItemType(userId, itemType);
        if (!emailSendConfigs.isEmpty()) {
            String currentDateTime = TimeUtils.getCurrentDateTime();
            EmailSendConfig emailSendConfig = emailSendConfigs.get(0);
            if (switchValue) {
                emailSendConfig.upsertItemMsg(stockCode);
            } else {
                emailSendConfig.deleteItemMsg(stockCode);
            }
            emailSendConfig.setUpdateTime(currentDateTime);
            emailSendConfigService.updateByPrimaryId(emailSendConfig);
        }
        return this.getEmailAllConfigByUserId(userId);
    }

    @CrossOrigin
    @GetMapping("/setting/emailSendConfig/deleteStockRow")
    String deleteStockRow(@RequestParam("stock_code") String stockCode, @RequestParam("user_id") String userId) throws JsonProcessingException {
        List<EmailSendConfig> emailSendConfigs = emailSendConfigService.selectByUserId(userId);
        String currentDateTime = TimeUtils.getCurrentDateTime();
        int updateNum = 0;
        if (!emailSendConfigs.isEmpty()) {
            Map<String, EmailSendConfig> map = new HashMap<>();
            for (EmailSendConfig emailSendConfig : emailSendConfigs) {
                map.put(emailSendConfig.getItemType(), emailSendConfig);
            }
            if (map.containsKey("stock_holding_change")) {
                EmailSendConfig emailSendConfig = map.get("stock_holding_change");
                if (emailSendConfig.deleteItemMsg(stockCode)) {
                    emailSendConfig.setUpdateTime(currentDateTime);
                    updateNum += emailSendConfigService.updateByPrimaryId(emailSendConfig);
                }
            }
            if (map.containsKey("stock_holding_change_senior_manager")) {
                EmailSendConfig emailSendConfig = map.get("stock_holding_change_senior_manager");
                if (emailSendConfig.deleteItemMsg(stockCode)) {
                    emailSendConfig.setUpdateTime(currentDateTime);
                    updateNum += emailSendConfigService.updateByPrimaryId(emailSendConfig);
                }
            }
            if (map.containsKey("company_announcement")) {
                EmailSendConfig emailSendConfig = map.get("company_announcement");
                if (emailSendConfig.deleteItemMsg(stockCode)) {
                    emailSendConfig.setUpdateTime(currentDateTime);
                    updateNum += emailSendConfigService.updateByPrimaryId(emailSendConfig);
                }
            }
        }
        return this.getEmailAllConfigByUserId(userId);
    }

    @CrossOrigin
    @GetMapping("/setting/emailSendConfig/queryByUserId")
    String getEmailConfigByUserId(@RequestParam("user_id") String userID) throws JsonProcessingException {
        List<EmailSendConfig> emailSendConfigs = emailSendConfigService.selectByUserId(userID);
        String json = JSONUtils.object2JsonString((Object) emailSendConfigs);
        return json;
    }

    @CrossOrigin
    @GetMapping("/setting/emailSendConfig/queryAllConfigByUserId")
    String getEmailAllConfigByUserId(@RequestParam("user_id") String userID) throws JsonProcessingException {
        List<EmailSendConfig> emailSendConfigs = emailSendConfigService.selectByUserId(userID);
        if (!emailSendConfigs.isEmpty()) {
            Map<String, EmailSendConfig> map = new HashMap<>();
            for (EmailSendConfig emailSendConfig : emailSendConfigs) {
                map.put(emailSendConfig.getItemType(), emailSendConfig);
            }
            Set<String> stockHoldChangeStockCodes = map.getOrDefault("stock_holding_change", new EmailSendConfig()).getStockCodes();
            Set<String> stockHoldChangeSeniorManagerStockCodes = map.getOrDefault("stock_holding_change_senior_manager", new EmailSendConfig()).getStockCodes();
            Set<String> noticeMsgStockCodes = map.getOrDefault("company_announcement", new EmailSendConfig()).getStockCodes();
            Set<String> allStockCodes = new HashSet<String>();
            allStockCodes.addAll(stockHoldChangeStockCodes);
            allStockCodes.addAll(stockHoldChangeSeniorManagerStockCodes);
            allStockCodes.addAll(noticeMsgStockCodes);
            if (!allStockCodes.isEmpty()) {
                String stockCodesStr = allStockCodes.stream().collect(Collectors.joining(","));
                /**获取stock_code,stock_name映射*/
                List<StockDetail> stockDetails = stockDetailService.queryByStockCodes(stockCodesStr);
                Map<String, StockDetail> stockCodeAndDetailMap = new HashMap<>();
                stockDetails.forEach(tmp -> {
                    stockCodeAndDetailMap.put(tmp.getStockCode(), tmp);
                });
                Map<String, JSONObject> result = new HashMap<>();
                allStockCodes.forEach(stockCode -> {
                    JSONObject jo = new JSONObject();
                    jo.put("stock_code", stockCode);
                    if (stockCodeAndDetailMap.containsKey(stockCode)) {
                        jo.put("stock_name", stockCodeAndDetailMap.get(stockCode).getStockName());
                    }
                    jo.put("stock_holding_change", stockHoldChangeStockCodes.contains(stockCode));
                    jo.put("stock_holding_change_senior_manager", stockHoldChangeSeniorManagerStockCodes.contains(stockCode));
                    jo.put("company_announcement", noticeMsgStockCodes.contains(stockCode));
                    result.put(stockCode, jo);
                });

                String json = new JSONArray(new LinkedList<>(result.values())).toJSONString();
                return json;
            }
        }
        return "[]";
    }

    @CrossOrigin
    @GetMapping("/setting/emailSendConfig/upsertAllItemEmpy")
    String upsertAllItemEmpy(@RequestParam("stock_detail_id") String stockDetailId, @RequestParam("user_id") String
            userId) {
        String currentDateTime = TimeUtils.getCurrentDateTime();
        List<StockDetail> stockDetails = stockDetailService.qeuryByColNameAndColValueEq("stock_detail_id", stockDetailId);
        int updateNum = 0;
        if (!stockDetails.isEmpty()) {
            String stockCode = stockDetails.get(0).getStockCode();
            List<EmailSendConfig> emailSendConfigs = emailSendConfigService.selectByUserId(userId);
            Map<String, EmailSendConfig> map = new HashMap<>();
            for (EmailSendConfig emailSendConfig : emailSendConfigs) {
                map.put(emailSendConfig.getItemType(), emailSendConfig);
            }
            if (map.containsKey("stock_holding_change")) {
                EmailSendConfig emailSendConfig = map.get("stock_holding_change");
                if (emailSendConfig.upsertItemMsg(stockCode)) {
                    emailSendConfig.setUpdateTime(currentDateTime);
                    updateNum += emailSendConfigService.updateByPrimaryId(emailSendConfig);
                }
            } else {
                EmailSendConfig emailSendConfig = new EmailSendConfig(-1, new Integer(userId), "stock_holding_change", "", "", "", stockCode, currentDateTime, currentDateTime);
                updateNum += emailSendConfigService.insertInto(emailSendConfig);
            }
            if (map.containsKey("stock_holding_change_senior_manager")) {
                EmailSendConfig emailSendConfig = map.get("stock_holding_change_senior_manager");
                if (emailSendConfig.upsertItemMsg(stockCode)) {
                    emailSendConfig.setUpdateTime(currentDateTime);
                    updateNum += emailSendConfigService.updateByPrimaryId(emailSendConfig);
                }
            } else {
                EmailSendConfig emailSendConfig = new EmailSendConfig(-1, new Integer(userId), "stock_holding_change_senior_manager", "", "", "", stockCode, currentDateTime, currentDateTime);
                updateNum += emailSendConfigService.insertInto(emailSendConfig);
            }
            if (map.containsKey("company_announcement")) {
                EmailSendConfig emailSendConfig = map.get("company_announcement");
                if (emailSendConfig.upsertItemMsg(stockCode)) {
                    emailSendConfig.setUpdateTime(currentDateTime);
                    updateNum += emailSendConfigService.updateByPrimaryId(emailSendConfig);
                }
            } else {
                EmailSendConfig emailSendConfig = new EmailSendConfig(-1, new Integer(userId), "company_announcement", "", "", "", stockCode, currentDateTime, currentDateTime);
                updateNum += emailSendConfigService.insertInto(emailSendConfig);
            }
        }
        return updateNum + "";
    }
}
