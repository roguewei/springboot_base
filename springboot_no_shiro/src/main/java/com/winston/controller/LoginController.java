package com.winston.controller;

import com.winston.entity.User;
import com.winston.result.CodeMsg;
import com.winston.result.Result;
import com.winston.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName LoginController
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/12/2 14:30
 * @Version：
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public Result login(){
        return Result.error(CodeMsg.IS_NOT_LOGIN);
    }

    @PostMapping("/login")
    public Result login(User user){
        Map<String, Object> login = loginService.login(user);
        return Result.success(login);
    }

    @GetMapping("/logout")
    public Result logout(){
        loginService.logout();
        return Result.success("已成功退出登录！");
    }

}
