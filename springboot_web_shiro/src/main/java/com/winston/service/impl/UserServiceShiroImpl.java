package com.winston.service.impl;

import com.winston.entity.User;
import com.winston.jwt.comment.RawAccessJwtToken;
import com.winston.mapper.UserMapper;
import com.winston.utils.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName UserServiceShiroImpl
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/11/27 10:10
 * @Version：
 */
@Service("userServiceExt")
public class UserServiceShiroImpl extends UserServiceImpl {

    @Autowired
    private PasswordHelper passwordHelper;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private RawAccessJwtToken rawAccessJwtToken;

    @Override
    public int save(User user) {
        String nicname = rawAccessJwtToken.getUserName();
        long nowTime = new Date().getTime();

        user.setEnable(1);
        user.setState("1");
        user.setCreateOpr("system");
        user.setCreateTime(nowTime);
        user.setUpdateOpr("system");
        user.setUpdateTime(nowTime);
        user.setOperatorType("0");
        user.setPassword(passwordHelper.encryptPassword(user.getUsername(), user.getPassword()));
        mapper.insert(user);
        return user.getId();
    }
}
