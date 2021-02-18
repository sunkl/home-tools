package com.sunkl.hometoolsserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.sunkl.hometoolsserver.dao.FamilyUser;
import com.sunkl.hometoolsserver.service.FamilyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/family_user")
public class FamliyUserController {

    @Autowired
    FamilyUserService familyUserService;

    @CrossOrigin
    @GetMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("passwd") String passwd) {
        FamilyUser user = familyUserService.findUserNameAndPasswd(username, passwd);
        String jsonString = "";
        if (user != null) {
            jsonString = JSON.toJSONString(user);
        }
        return jsonString;
    }

    @CrossOrigin
    @GetMapping("/register")
    public boolean register(
            @RequestParam("username") String username,
            @RequestParam("passwd") String passwd,
            @RequestParam("role") String role,
            @RequestParam("birth_day") String birthDay,
            @RequestParam("nice_name") String niceName,
            @RequestParam("phone") String phone) {
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return familyUserService.insertInto(new FamilyUser(
                -1,
                username,
                passwd,
                role,
                "",
                niceName,
                phone,
                birthDay,
                currentTime,
                currentTime,
                ""
        ));
    }

    @CrossOrigin
    @GetMapping("/user_query")
    public String getUserByColNameAndKey(@RequestParam("col_name") String[] colName, @RequestParam("key") String key) throws JsonProcessingException {
        List<FamilyUser> users = familyUserService.findUserByColName(colName[0], key);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE);
        String json = mapper.writeValueAsString(users);
        return json;
    }

    @CrossOrigin
    @GetMapping("/queryUserById")
    public String getUserByUserID(@RequestParam("user_id") String userID) throws JsonProcessingException {
        List<FamilyUser> users = familyUserService.findUserByCondition("user_id=" + userID);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE);
        String json = mapper.writeValueAsString(users);
        return json;
    }
}
