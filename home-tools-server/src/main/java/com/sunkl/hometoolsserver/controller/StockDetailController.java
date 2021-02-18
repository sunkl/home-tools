package com.sunkl.hometoolsserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sunkl.hometoolsserver.dao.StockDetail;
import com.sunkl.hometoolsserver.service.StockDetailService;
import com.sunkl.hometoolsserver.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/family_user")
public class StockDetailController {
    @Autowired
    StockDetailService stockDetailService;


    @CrossOrigin
    @GetMapping("/qeuryStockDetailByColName")
    public String queryStockDetailByColAndKeyLike(@RequestParam("col_name") String colName, @RequestParam("col_value") String colValue) throws JsonProcessingException {
        List<StockDetail> stockDetails = stockDetailService.qeuryByColNameAndColValueLike(colName, colValue);
        String json = JSONUtils.object2JsonString((Object) stockDetails);
        System.out.println(json);
        return json;
    }

    @CrossOrigin
    @GetMapping("/queryStockByStockDetailId")
    public String queryStockByStockDetailId(@RequestParam("stock_detail_id") String stockDetailId) throws JsonProcessingException {
        List<StockDetail> stockDetails = stockDetailService.qeuryByColNameAndColValueEq("stock_detail_id", stockDetailId);
        return JSONUtils.object2JsonString((Object) stockDetails);
    }
}
