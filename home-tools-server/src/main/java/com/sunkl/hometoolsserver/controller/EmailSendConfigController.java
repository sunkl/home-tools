package com.sunkl.hometoolsserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sunkl.hometoolsserver.dao.EmailSendConfig;
import com.sunkl.hometoolsserver.service.EmailSendConfigService;
import com.sunkl.hometoolsserver.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/family_user")
public class EmailSendConfigController {
    @Autowired
    EmailSendConfigService emailSendConfigService;

    @CrossOrigin
    @GetMapping("/setting/emailSendConfig/queryByUserId")
    String getEmailConfigByUserId(@RequestParam("user_id") String userID) throws JsonProcessingException {
        List<EmailSendConfig> emailSendConfigs = emailSendConfigService.selectByUserId(userID);
        String json = JSONUtils.object2JsonString((Object) emailSendConfigs);
        return json;
    }

    @CrossOrigin
    @GetMapping("/setting/emailSendConfig/upsertAllItemEmpy")
    String upsertAllItemEmpy(
            @RequestParam("stock_code") String stockCode) {

    }
}
