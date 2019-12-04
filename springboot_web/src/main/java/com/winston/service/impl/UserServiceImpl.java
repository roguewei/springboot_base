package com.winston.service.impl;

import com.winston.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/12/4 14:31
 * @Version：
 */
@Service("userService")
public class UserServiceImpl extends UserServiceBaseImpl {

    public List<User> queryAll() {
        return super.queryAll();
    }

}
