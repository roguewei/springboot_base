package com.winston.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winston.entity.User;
import com.winston.entity.UserExample;
import com.winston.exception.ErrorException;
import com.winston.mapper.UserMapper;
import com.winston.result.CodeMsg;
import com.winston.result.Result;
import com.winston.service.IUserService;
import com.winston.utils.PasswordHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Winston
 * @title: UserServiceImpl
 * @projectName shiroDemo
 * @description: 基本方法 没必要就尽量不改动这里的代码，而使用继承子类去扩展
 * @date 2019/7/24 14:25
 */
@Service("userServiceBase")
public class UserServiceBaseImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private PasswordHelper passwordHelper;

    @Override
    public List<User> queryAll() {
        return mapper.selectByExample(new UserExample());
    }

    @Override
    public Result queryByUser(User user, int page, int length) {
        PageHelper.startPage(page, length);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(user.getId() != null){
            criteria.andIdEqualTo(user.getId());
        }
        if(StringUtils.isNotBlank(user.getUsername())) {
            criteria.andUsernameEqualTo(user.getUsername());
        }
        if(user.getOpenId() != null){
            criteria.andOpenIdEqualTo(user.getOpenId());
        }
        List<User> users = mapper.selectByExample(example);
        users.forEach(item -> {
            item.setPassword("");
        });
        PageInfo pageInfo = new PageInfo(users);
        return Result.success(users, pageInfo.getTotal());
    }

    @Override
    public User queryById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public User queryByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> users = mapper.selectByExample(example);
        if(users != null && users.size() > 0){
            return users.get(0);
        }
        return null;
    }


    @Override
    public int save(User user) {
        User exist = queryByUsername(user.getUsername());
        if(exist != null){
            throw new ErrorException(CodeMsg.USER_ALREADY_EXIST);
        }
//        String nicname = rawAccessJwtToken.getUserName();
        long nowTime = new Date().getTime();

        user.setEnable(1);
        user.setState("1");
        user.setCreateOpr("system");
        user.setCreateTime(nowTime);
        user.setUpdateOpr("system");
        user.setUpdateTime(nowTime);
        user.setOperatorType("0");
        passwordHelper.encryptPassword(user.getUsername(), user.getPassword());
        mapper.insert(user);
        return user.getId();
    }

    @Override
    public void update(User user) {
        if(user == null || user.getId() == null){
            throw new ErrorException(CodeMsg.USER_UPDATE_FAILED);
        }
        user.setPassword(null);
        int i = mapper.updateByPrimaryKeySelective(user);
        if(i <= 0){
            throw new ErrorException(CodeMsg.USER_UPDATE_FAILED);
        }
    }

    @Override
    public void delete(Integer id) {
        User user = mapper.selectByPrimaryKey(id);
        if(user != null){
            user.setState("1");
            mapper.updateByPrimaryKeySelective(user);
        }else{
            throw new ErrorException(CodeMsg.USER_DEL_FAILE);
        }
    }

    @Override
    public User queryByOpenId(String openId) {
//        UserExample example = new UserExample();
//        example.createCriteria().andOpenIdEqualTo(openId);
//        List<User> users = mapper.selectByExample(example);
//        return users.get(0);
        return null;
    }
}
