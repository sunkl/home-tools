package com.sunkl.hometoolsserver.mapper;

import com.sunkl.hometoolsserver.dao.StockDetail;
import com.sunkl.hometoolsserver.dao.StockDetailExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface StockDetailMapper {
    List<StockDetail> selectByCondition(String condition);

   /* int countByExample(StockDetailExample example);

    int deleteByExample(StockDetailExample example);

    int deleteByPrimaryKey(Integer stockDetailId);

    int insert(StockDetail record);

    int insertSelective(StockDetail record);

    List<StockDetail> selectByExample(StockDetailExample example);

    StockDetail selectByPrimaryKey(Integer stockDetailId);

    int updateByExampleSelective(@Param("record") StockDetail record, @Param("example") StockDetailExample example);

    int updateByExample(@Param("record") StockDetail record, @Param("example") StockDetailExample example);

    int updateByPrimaryKeySelective(StockDetail record);

    int updateByPrimaryKey(StockDetail record);*/
}