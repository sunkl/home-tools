package com.sunkl.hometoolsserver.service;

import com.sunkl.hometoolsserver.dao.FamilyUser;
import com.sunkl.hometoolsserver.mapper.FamilyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyUserService {
    @Autowired
    FamilyUserMapper familyUserMapper;

    public FamilyUser findUserNameAndPasswd(String userName, String passwd) {
        List<FamilyUser> familyUsers = familyUserMapper.selectByUserNameAndPasswd(userName, passwd);
        FamilyUser result = null;
        if (familyUsers != null && !familyUsers.isEmpty()) {
            result = familyUsers.get(0);
        }
        return result;
    }

    public boolean insertInto(FamilyUser familyUser) {
        return familyUserMapper.insert(familyUser) > 0;
    }
}
