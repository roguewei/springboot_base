package com.winston.service;

import com.winston.entity.User;
import com.winston.jwt.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LoginServiceImpl
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/11/26 17:13
 * @Version：
 */
@Service
public class LoginService {

    @Autowired
    private IUserService userServiceBase;

    @Autowired
    private TokenService tokenService;

    public Map<String, Object> login(HttpServletRequest request, User user) {
        User dbUser = userServiceBase.queryByUsername(user.getUsername());
        String token = tokenService.getToken(dbUser.getId(), dbUser.getUsername());
        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        dbUser.setPassword("");
        result.put("userInfo", dbUser);
        return result;
    }

    public void logout(HttpServletRequest request) {
        tokenService.clearToken();
    }
}
