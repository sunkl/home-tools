package com.sunkl.hometoolsserver.mapper;

import com.sunkl.hometoolsserver.dao.EmailMsg;
import com.sunkl.hometoolsserver.dao.EmailMsgExample;

import java.util.List;

import com.sunkl.hometoolsserver.dao.EmailSendConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmailMsgMapper {
    List<EmailMsg> selectEmailMsgByCondition(String condition);

    int insertIntoAll(List<EmailMsg> emailSendConfig);

    int countByExample(EmailMsgExample example);

    int deleteByExample(EmailMsgExample example);

    int deleteByPrimaryKey(Integer emailMsgId);

    int insert(EmailMsg record);

    int insertSelective(EmailMsg record);

    List<EmailMsg> selectByExample(EmailMsgExample example);

    List<EmailMsg> selectByCondition(String condition);

    int updateIsSend(String emailMsgIds, String isSend, String updateTime);

    EmailMsg selectByPrimaryKey(Integer emailMsgId);

    int updateByExampleSelective(@Param("record") EmailMsg record, @Param("example") EmailMsgExample example);

    int updateByExample(@Param("record") EmailMsg record, @Param("example") EmailMsgExample example);

    int updateByPrimaryKeySelective(EmailMsg record);

    int updateByPrimaryKey(EmailMsg record);
}