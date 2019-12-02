package com.winston.jwt;


import com.winston.constant.Commons;
import com.winston.jwt.comment.JwtTokenFactory;
import com.winston.jwt.comment.RawAccessJwtToken;
import com.winston.properties.SecurityProperties;
import com.winston.redis.RedisService;
import com.winston.redis.key.SessionRedisKey;
import com.winston.redis.key.TokenKey;
import com.winston.utils.HttpUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class TokenService {


    @Autowired
    private RawAccessJwtToken rawAccessJwtToken;

    @Autowired
    private RedisService redisService;

    @Autowired
    private JwtTokenFactory jwtTokenFactory;

    @Autowired
    private SecurityProperties securityProperties;


    public Integer getIdByToken(HttpServletRequest request) {
        return rawAccessJwtToken.getUserId();
    }

    public Claims getClaims(HttpServletRequest request) {
        return rawAccessJwtToken.getClaims();
    }

    public boolean authToken(HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();
        if(session == null){
            return false;
        }
        String headerToken = httpServletRequest.getHeader(securityProperties.getJwt().getHeader());
        String sessionId = httpServletRequest.getSession().getId();
        if (sessionId != null) {
            //处理token，
            String token = redisService.get(TokenKey.LOGINTOKEN, sessionId, String.class);
            if (StringUtils.isBlank(headerToken) || StringUtils.isBlank(token)) {
                return false;
            }else{
                if(!headerToken.equals(token)){
                    return false;
                }
                //redis处理token，重置过期时间，用于可以在线时长
                redisService.retExpire(TokenKey.LOGINTOKEN, sessionId,(int)securityProperties.getJwt().getTokenExpirationTime()/1000 , token);
                return true;
            }
        } else {
            return false;
        }
    }

    /***
     * 构建token
     * @param userId sername
     * @return
     */
    public String getToken(Integer userId, String username) {
        HttpServletRequest request = HttpUtil.getRequest();
        String sessionId = request.getSession().getId();
        Claims claims = Jwts.claims().setSubject(username);

        claims.put(Commons.USER_ID, userId);
        claims.put(Commons.USER_NAME, username);

        String jwtToken = jwtTokenFactory.createJwtToken(claims).getToken(); // 构建token
        redisService.set(TokenKey.LOGINTOKEN, sessionId, jwtToken);
        return jwtToken;
    }

    public void clearToken() {
        String sessionId = getSessionId();
        redisService.del(TokenKey.LOGINTOKEN, sessionId);

        redisService.del(SessionRedisKey.SESSION_KEY, sessionId);
    }

    public void clearSessionKey(String key) {
        redisService.del("shiro:session:" + key);
    }

    private String getSessionId(){
        HttpServletRequest request = HttpUtil.getRequest();
        String sessionId = request.getSession().getId();
        return sessionId;
    }

}
