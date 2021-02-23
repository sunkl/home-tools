package com.sunkl.hometoolsserver.mapper;

import com.sunkl.hometoolsserver.dao.SchulerTaskConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchulerTaskConfigMapper {
    List<SchulerTaskConfig> selectSTCByCondition(String condition);

    int deleteByPrimaryKey(Integer taskId);

    int insert(SchulerTaskConfig record);

    int insertSelective(SchulerTaskConfig record);

    SchulerTaskConfig selectByPrimaryKey(Integer taskId);

    int updateByPrimaryKeySelective(SchulerTaskConfig record);

    int updateByPrimaryKey(SchulerTaskConfig record);
}