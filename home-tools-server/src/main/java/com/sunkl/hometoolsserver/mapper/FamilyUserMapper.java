package com.sunkl.hometoolsserver.mapper;

import com.sunkl.hometoolsserver.dao.FamilyUser;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FamilyUserMapper {

    int insert(FamilyUser record);

    List<FamilyUser> selectByUserNameAndPasswd(@Param("username") String userName, @Param("passwd") String passwd);

    List<FamilyUser> selectUserByCondition(@Param("condition_str") String condition_str);

    List<FamilyUser> selectUserByColName(@Param("col_name") String colName, @Param("col_value") String key);

    List<FamilyUser> selectUser();

}