package com.winston.service.impl;

import com.winston.entity.User;
import com.winston.exception.ErrorException;
import com.winston.jwt.comment.RawAccessJwtToken;
import com.winston.mapper.UserMapper;
import com.winston.result.CodeMsg;
import com.winston.utils.PasswordHelper;
import com.winston.utils.StringUtil;
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
@Service("userService")
public class UserServiceImpl extends UserServiceBaseImpl {

    @Autowired
    private PasswordHelper passwordHelper;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private RawAccessJwtToken rawAccessJwtToken;

    @Override
    public int save(User user) {
        User exist = super.queryByUsername(user.getUsername());
        if(exist != null){
            throw new ErrorException(CodeMsg.USER_ALREADY_EXIST);
        }

        String userName = rawAccessJwtToken.getUserName();
        long nowTime = new Date().getTime();
        String salt = StringUtil.getRandomString(5);

        user.setEnable("1");
        user.setState("1");
        user.setCreateOpr(userName);
        user.setCreateTime(nowTime);
        user.setUpdateOpr(userName);
        user.setUpdateTime(nowTime);
        user.setOperatorType("0");
        user.setSalt(salt);
        user.setPassword(passwordHelper.encryptPasswordSalt(user.getPassword(), salt));
        mapper.insertSelective(user);
        return user.getId();
    }

}
