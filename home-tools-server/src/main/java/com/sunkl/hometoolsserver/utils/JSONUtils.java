package com.sunkl.hometoolsserver.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.stereotype.Service;

@Service
public class JSONUtils {
    public static String object2JsonString(Object o) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE);
        String json = mapper.writeValueAsString(o);
        return json;
    }
}
