package com.sunkl.hometoolsserver.mapper;

import com.sunkl.hometoolsserver.dao.StockHoldingChangeSeniorManagerment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockHoldingChangeSeniorManagermentMapper {
    int insert(StockHoldingChangeSeniorManagerment record);

    int insertSelective(StockHoldingChangeSeniorManagerment record);

    List<StockHoldingChangeSeniorManagerment> selectSCSMByCondition(String condition);
}