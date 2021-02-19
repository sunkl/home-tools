package com.sunkl.hometoolsserver.service;

import com.sunkl.hometoolsserver.dao.EmailSendConfig;
import com.sunkl.hometoolsserver.mapper.EmailSendConfigMapper;
import com.sunkl.hometoolsserver.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailSendConfigService {
    @Autowired
    EmailSendConfigMapper emailSendConfigMapper;
    public int upsertBaseConfig(String userId, String itemType, String itemMsg) {
        String currentDateTime = TimeUtils.getCurrentDateTime();
        EmailSendConfig emailSendConfig = new EmailSendConfig(new Integer(-1), new Integer(userId), itemType, "", "", "", itemMsg, currentDateTime, currentDateTime);
        return emailSendConfigMapper.upsertByPK(emailSendConfig);
    }

    public List<EmailSendConfig> selectByUserIdAndItemType(String userId, String itemType) {
        return emailSendConfigMapper.selectByCondition(String.format(" user_id = '%s' and item_type='%s'", userId, itemType));
    }

    public List<EmailSendConfig> selectByUserId(String userId) {
        return emailSendConfigMapper.selectByCondition("user_id = '" + userId + "'");
    }

    public int updateByPrimaryId(EmailSendConfig emailSendConfig) {
        return emailSendConfigMapper.updateByPrimaryKey(emailSendConfig);
    }

    public int insertInto(EmailSendConfig emailSendConfig) {
        return emailSendConfigMapper.insertInto(emailSendConfig);
    }
}
