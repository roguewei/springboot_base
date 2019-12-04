package com.winston.interceptor;

import com.winston.entity.User;
import com.winston.jwt.TokenService;
import com.winston.properties.SecurityProperties;
import com.winston.redis.RedisService;
import com.winston.redis.key.SessionRedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName Logininterceptor
 * @Author: Winston
 * @Description: 拦截未登录的请求
 * @Date:Create：in 2019/10/9 16:13
 * @Version：
 */
@Component
public class Logininterceptor implements HandlerInterceptor {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求头带回来的token
        String token = request.getHeader(securityProperties.getJwt().getHeader());
        if(token == null){
            response.sendRedirect(request.getContextPath()+"/login");
        }
        // 校验token
        if(!tokenService.authToken(request)){
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }else{
            return true;
        }
//        //        得到session
//        HttpSession session = request.getSession(true);
//        //        得到对象
//        User userInfo = redisService.get(SessionRedisKey.SESSION_KEY, session.getId(), User.class);
//        //        判断对象是否存在
//        if(userInfo != null){
//            return true;
//        }else{
//            //            不存在则跳转到登录页
//            response.sendRedirect(request.getContextPath()+"/login");
//            return false;
//        }
    }
}
