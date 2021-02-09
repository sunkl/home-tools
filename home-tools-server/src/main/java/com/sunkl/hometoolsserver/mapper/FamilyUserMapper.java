package com.sunkl.hometoolsserver.mapper;

import com.sunkl.hometoolsserver.dao.FamilyUser;
import com.sunkl.hometoolsserver.dao.FamilyUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FamilyUserMapper {
    int countByExample(FamilyUserExample example);

    int deleteByExample(FamilyUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(FamilyUser record);

    int insertSelective(FamilyUser record);

    List<FamilyUser> selectByExample(FamilyUserExample example);

    List<FamilyUser> selectByUserNameAndPasswd(@Param("username") String userName, @Param("passwd") String passwd);

    FamilyUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") FamilyUser record, @Param("example") FamilyUserExample example);

    int updateByExample(@Param("record") FamilyUser record, @Param("example") FamilyUserExample example);

    int updateByPrimaryKeySelective(FamilyUser record);

    int updateByPrimaryKey(FamilyUser record);

}