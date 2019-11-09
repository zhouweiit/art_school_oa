package com.chengzi.art.school.oa.service;

import com.chengzi.art.school.oa.persistence.mysql.artoa.dao.UserAuthDao;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private UserAuthDao userAuthDao;

    public UserAuth checkUserPassword(String username, String password) {
        UserAuth userAuth = userAuthDao.selectByLoginName(username);
        if (userAuth == null) {
            return null;
        }
        String saltPassword = UserAuth.createPassword(userAuth.getSalt(), password);
        if (Objects.equals(saltPassword, userAuth.getLoginPassword())) {
            return userAuth;
        }
        return null;
    }

}
