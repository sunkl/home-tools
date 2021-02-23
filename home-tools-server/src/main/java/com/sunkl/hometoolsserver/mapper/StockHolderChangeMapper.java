package com.sunkl.hometoolsserver.mapper;

import com.sunkl.hometoolsserver.dao.StockHolderChange;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StockHolderChangeMapper {
    int insert(StockHolderChange record);

    int insertSelective(StockHolderChange record);

    List<StockHolderChange> selectByCondition(String condition);
}