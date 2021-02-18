package com.sunkl.hometoolsserver.service;

import com.sunkl.hometoolsserver.dao.EmailSendConfig;
import com.sunkl.hometoolsserver.mapper.EmailSendConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailSendConfigService {
    @Autowired
    EmailSendConfigMapper emailSendConfigMapper;

    public List<EmailSendConfig> selectByUserId(String userId) {
        return emailSendConfigMapper.selectByCondition("user_id = '" + userId + "'");
    }
}
