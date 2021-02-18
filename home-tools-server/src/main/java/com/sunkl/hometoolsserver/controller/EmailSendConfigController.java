package com.sunkl.hometoolsserver.controller;

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

@RestController
@RequestMapping("/api/family_user")
public class EmailSendConfigController {
    @Autowired
    EmailSendConfigService emailSendConfigService;
    @Autowired
    StockDetailService stockDetailService;

    @CrossOrigin
    @GetMapping("/setting/emailSendConfig/queryByUserId")
    String getEmailConfigByUserId(@RequestParam("user_id") String userID) throws JsonProcessingException {
        List<EmailSendConfig> emailSendConfigs = emailSendConfigService.selectByUserId(userID);
        String json = JSONUtils.object2JsonString((Object) emailSendConfigs);
        return json;
    }

    @CrossOrigin
    @GetMapping("/setting/emailSendConfig/upsertAllItemEmpy")
    String upsertAllItemEmpy(@RequestParam("stock_detail_id") String stockDetailId, @RequestParam("user_id") String userId) {
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
            if (map.containsKey("stock_hold_change")) {
                EmailSendConfig emailSendConfig = map.get("stock_hold_change");
                if (emailSendConfig.upsertItemMsg(stockCode)) {
                    emailSendConfig.setUpdateTime(currentDateTime);
                    updateNum += emailSendConfigService.updateByPrimaryId(emailSendConfig);
                }
            } else {
                EmailSendConfig emailSendConfig = new EmailSendConfig(-1, new Integer(userId), "stock_hold_change", "", "", "", stockCode, currentDateTime, currentDateTime);
                updateNum += emailSendConfigService.insertInto(emailSendConfig);
            }
            if (map.containsKey("stock_hold_change_senior_manager")) {
                EmailSendConfig emailSendConfig = map.get("stock_hold_change_senior_manager");
                if (emailSendConfig.upsertItemMsg(stockCode)) {
                    emailSendConfig.setUpdateTime(currentDateTime);
                    updateNum += emailSendConfigService.updateByPrimaryId(emailSendConfig);
                }
            } else {
                EmailSendConfig emailSendConfig = new EmailSendConfig(-1, new Integer(userId), "stock_hold_change_senior_manager", "", "", "", stockCode, currentDateTime, currentDateTime);
                updateNum += emailSendConfigService.insertInto(emailSendConfig);
            }
            if (map.containsKey("notice_msg")) {
                EmailSendConfig emailSendConfig = map.get("notice_msg");
                if (emailSendConfig.upsertItemMsg(stockCode)) {
                    emailSendConfig.setUpdateTime(currentDateTime);
                    updateNum += emailSendConfigService.updateByPrimaryId(emailSendConfig);
                }
            } else {
                EmailSendConfig emailSendConfig = new EmailSendConfig(-1, new Integer(userId), "notice_msg", "", "", "", stockCode, currentDateTime, currentDateTime);
                updateNum += emailSendConfigService.insertInto(emailSendConfig);
            }
        }
        return updateNum + "";
    }
}
