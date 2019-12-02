package com.winston.controller;

import com.winston.entity.Permission;
import com.winston.result.Result;
import com.winston.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName PermissionController
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/11/28 9:42
 * @Version：
 */
@RestController
@RequestMapping("/web/per")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @GetMapping("/queryByUsername")
    public Result queryByUsername(String username){
        List<Permission> permissions = permissionService.queryByUserName(username);
        return Result.success(permissions);
    }

}
