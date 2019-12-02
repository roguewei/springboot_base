package com.winston.controller;

import com.winston.entity.User;
import com.winston.jwt.TokenService;
import com.winston.result.CodeMsg;
import com.winston.result.Result;
import com.winston.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Winston
 * @title: LoginController
 * @projectName shiroDemo
 * @description:
 * @date 2019/7/24 16:24
 */
@Api(tags = "登录模块")
@RestController
public class LoginController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录提示，无需调用", notes = "提示未登录")
    @GetMapping("/login")
    public Result login(){
        return Result.error(CodeMsg.IS_NOT_LOGIN);
    }

    @ApiOperation(value = "登录请求", notes = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
    })
    @PostMapping("/login")
    public Result login(HttpServletRequest request, User user){
        Map<String, Object> login = loginService.login(request, user);
        return Result.success(login);
    }

    @GetMapping("/logout")
    public Result logout(){
        tokenService.clearToken();

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Result.success("您已退出登录");
    }

    @GetMapping("/unauthorized")
    public Result unauthorized(){
        return Result.success("未登录，请重新登录");
    }
}
