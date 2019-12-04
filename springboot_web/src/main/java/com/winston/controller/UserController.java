package com.winston.controller;

import com.winston.entity.User;
import com.winston.result.Result;
import com.winston.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/12/4 14:33
 * @Version：
 */
@RestController
@RequestMapping("/web/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public Result queryAll(){
        List<User> users = userService.queryAll();
        return Result.success(users);
    }

}
