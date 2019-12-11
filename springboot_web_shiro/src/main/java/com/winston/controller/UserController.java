package com.winston.controller;

import com.winston.entity.User;
import com.winston.result.Result;
import com.winston.service.IUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/10/10 11:48
 * @Version：
 */
@Api(description = "用户接口")
@RestController
@RequestMapping("/web/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "用户查询", notes = "用户查询")//接口说明
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = false, dataType = "String", paramType = "Integer"),
            @ApiImplicitParam(name = "userPhone", value = "合同年度", required = false, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "userMail", value = "用户邮箱", required = false, dataType = "String", paramType = "Integer"),
            @ApiImplicitParam(name = "orderBy", value = "排序标识", required = false, dataType = "String", paramType = "Integer"),
            @ApiImplicitParam(name = "page", value = "页码,第几页", required = false, dataType = "Integer", paramType = "Integer"),
            @ApiImplicitParam(name = "length", value = "每页数量", required = false, dataType = "Integer", paramType = "Integer")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功请求", response = Result.class),
            @ApiResponse(code = 401, message = "无权限访问"),
            @ApiResponse(code = 500203, message = "未登录")
    })
    @GetMapping
    public Result query(@RequestParam(required = false, defaultValue = "1") int page,
                        @RequestParam(required = false, defaultValue = "10") int length,
                        User user){
        return userService.queryByUser(user, page, length);
    }

    @ApiOperation(value = "用户id查询", notes = "用户id查询")//接口说明
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer", paramType = "Integer"),
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功请求", response = Result.class),
            @ApiResponse(code = 401, message = "无权限访问"),
            @ApiResponse(code = 500203, message = "未登录")
    })
    @GetMapping("/{id}")
    public Result query(@PathVariable Integer id){
        return Result.success(userService.queryById(id));
    }

    @ApiOperation(value = "注册用户", notes = "注册用户")//接口说明
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "userPass", value = "用户真实姓名", required = false, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "userMail", value = "用户邮箱", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "userPhone", value = "合同年度", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "userMail", value = "用户邮箱", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "customerId", value = "保定开户id", required = false, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "customerName", value = "保定开户名", required = false, dataType = "String", paramType = "String"),
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功请求", response = Result.class),
            @ApiResponse(code = 401, message = "无权限访问"),
            @ApiResponse(code = 500203, message = "未登录")
    })
    @PostMapping("/regester")
    public Result regester(@RequestBody User user){
        userService.save(user);
        return Result.success("新增用户成功");
    }

    @ApiOperation(value = "修改用户", notes = "修改用户")//接口说明
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编号", required = true, dataType = "Long", paramType = "Long"),
            @ApiImplicitParam(name = "userName", value = "用户名", required = false, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "userPass", value = "用户真实姓名", required = false, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "userMail", value = "用户邮箱", required = false, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "userPhone", value = "合同年度", required = false, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "userMail", value = "用户邮箱", required = false, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "customerId", value = "保定开户id", required = false, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "customerName", value = "保定开户名", required = false, dataType = "String", paramType = "String"),
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功请求", response = Result.class),
            @ApiResponse(code = 401, message = "无权限访问"),
            @ApiResponse(code = 500203, message = "未登录")
    })
    @PostMapping("/update")
    public Result update(@RequestBody User user){
        userService.update(user);
        return Result.success("修改用户成功");
    }

    @PostMapping("/updatePwd")
    public Result updatePwd(@RequestBody User user){
        userService.updatePwd(user);
        return Result.success("修改密码成功");
    }

    @GetMapping("/del")
    public Result del(Long userId){
//        userService.del(userId);
        return Result.success("删除用户成功");
    }

    @GetMapping("/freeze")
    public Result freeze(Long userId){
//        userService.freeze(userId);
        return Result.success("冻结用户成功");
    }

}
