package com.sunkl.hometoolsserver.mapper;

import com.sunkl.hometoolsserver.dao.ToolsModelConfig;
import com.sunkl.hometoolsserver.dao.ToolsModelConfigExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ToolsModelConfigMapper {
    int countByExample(ToolsModelConfigExample example);

    int deleteByExample(ToolsModelConfigExample example);

    int deleteByPrimaryKey(Integer toolsId);

    int insert(ToolsModelConfig record);

    int insertSelective(ToolsModelConfig record);

    List<ToolsModelConfig> selectByExample(ToolsModelConfigExample example);

    ToolsModelConfig selectByPrimaryKey(Integer toolsId);

    int updateByExampleSelective(@Param("record") ToolsModelConfig record, @Param("example") ToolsModelConfigExample example);

    int updateByExample(@Param("record") ToolsModelConfig record, @Param("example") ToolsModelConfigExample example);

    int updateByPrimaryKeySelective(ToolsModelConfig record);

    int updateByPrimaryKey(ToolsModelConfig record);
}