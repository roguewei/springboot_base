package com.winston.service;


import com.winston.entity.User;
import com.winston.result.Result;

import java.util.List;

public interface IUserService {

    List<User> queryAll();

    Result queryByUser(User user, int page, int length);

    User queryById(Integer id);

    User queryByUsername(String username);

    User queryByOpenId(String openId);

    int save(User user);

    void update(User user);

    void delete(Integer id);
}
