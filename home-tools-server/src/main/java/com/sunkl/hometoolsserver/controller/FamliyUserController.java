package com.sunkl.hometoolsserver.controller;

import com.alibaba.fastjson.JSON;
import com.sunkl.hometoolsserver.dao.FamilyUser;
import com.sunkl.hometoolsserver.service.FamilyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
