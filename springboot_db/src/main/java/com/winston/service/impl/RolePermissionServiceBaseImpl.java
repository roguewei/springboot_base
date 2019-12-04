package com.winston.service.impl;

import com.winston.entity.RolePermissionExample;
import com.winston.entity.RolePermissionKey;
import com.winston.mapper.RolePermissionMapper;
import com.winston.service.IRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Winston
 * @title: RolePermissionServiceImpl
 * @projectName shiroDemo
 * @description: 基本方法 没必要就尽量不改动这里的代码，而使用继承子类去扩展
 * @date 2019/7/24 14:32
 */
@Service("rolePermissionServiceBase")
public class RolePermissionServiceBaseImpl implements IRolePermissionService {

    @Autowired
    private RolePermissionMapper mapper;

    @Override
    public List<RolePermissionKey> queryByRoleIds(List<Integer> roleIds) {
        RolePermissionExample example = new RolePermissionExample();
        example.createCriteria().andRoleIdIn(roleIds);
        List<RolePermissionKey> rolePermissionKeys = mapper.selectByExample(example);
        return rolePermissionKeys;
    }
}
