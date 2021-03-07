package com.sunkl.hometoolsserver.mapper;

import com.sunkl.hometoolsserver.dao.ScrawConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScrawConfigMapper {
    List<ScrawConfig> selectByCondition(String conditionStr);

    int deleteByPrimaryKey(Integer scrawId);

    int insert(ScrawConfig record);

    int insertSelective(ScrawConfig record);

    ScrawConfig selectByPrimaryKey(Integer scrawId);

    int updateByPrimaryKeySelective(ScrawConfig record);

    int updateByPrimaryKey(ScrawConfig record);
}