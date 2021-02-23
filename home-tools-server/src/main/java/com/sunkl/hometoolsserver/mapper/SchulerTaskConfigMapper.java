package com.sunkl.hometoolsserver.mapper;

import com.sunkl.hometoolsserver.dao.SchulerTaskConfig;

public interface SchulerTaskConfigMapper {
    int deleteByPrimaryKey(Integer taskId);

    int insert(SchulerTaskConfig record);

    int insertSelective(SchulerTaskConfig record);

    SchulerTaskConfig selectByPrimaryKey(Integer taskId);

    int updateByPrimaryKeySelective(SchulerTaskConfig record);

    int updateByPrimaryKey(SchulerTaskConfig record);
}