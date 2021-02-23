package com.sunkl.hometoolsserver.mapper;

import com.sunkl.hometoolsserver.dao.EmailSendConfig;
import com.sunkl.hometoolsserver.dao.EmailSendConfigExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmailSendConfigMapper {
    List<EmailSendConfig> selectByCondition(String condition);

    int insertInto(EmailSendConfig emailSendConfig);



    int updateByPrimaryKey(EmailSendConfig record);

    int upsertByPK(EmailSendConfig record);
/*    int countByExample(EmailSendConfigExample example);

    int deleteByExample(EmailSendConfigExample example);

    int deleteByPrimaryKey(Integer emailSendConfigId);

    int insert(EmailSendConfig record);

    int insertSelective(EmailSendConfig record);


    EmailSendConfig selectByPrimaryKey(Integer emailSendConfigId);

    int updateByExampleSelective(@Param("record") EmailSendConfig record, @Param("example") EmailSendConfigExample example);

    int updateByExample(@Param("record") EmailSendConfig record, @Param("example") EmailSendConfigExample example);

    int updateByPrimaryKeySelective(EmailSendConfig record);

    int updateByPrimaryKey(EmailSendConfig record);*/
}