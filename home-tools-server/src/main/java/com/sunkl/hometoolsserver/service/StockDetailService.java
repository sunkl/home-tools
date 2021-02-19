package com.sunkl.hometoolsserver.service;

import com.sunkl.hometoolsserver.dao.StockDetail;
import com.sunkl.hometoolsserver.mapper.StockDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockDetailService {
    @Autowired
    StockDetailMapper stockDetailMapper;

    public List<StockDetail> qeuryByColNameAndColValueLike(String colName, String colValue) {
        StringBuffer condition = new StringBuffer()
                .append(colName)
                .append(" like '%")
                .append(colValue)
                .append("%'");
        return stockDetailMapper.selectByCondition(condition.toString());
    }

    public List<StockDetail> qeuryByColNameAndColValueEq(String colName, String colValue) {
        StringBuffer condition = new StringBuffer()
                .append(colName)
                .append(" = '")
                .append(colValue)
                .append("'");
        return stockDetailMapper.selectByCondition(condition.toString());
    }

    public List<StockDetail> queryByStockCodes(String stockCodes) {
        String conditionStr = String.format("stock_code in ( %s )", stockCodes);
        return stockDetailMapper.selectByCondition(conditionStr);
    }
}
