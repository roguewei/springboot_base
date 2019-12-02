package com.winston.redis.key;

public class SessionRedisKey extends BasePrefix {



    public SessionRedisKey(int expireSeconds, String preFix) {
        super(expireSeconds, preFix);
    }

    public SessionRedisKey(String preFix) {
        super(preFix);
    }

    public static SessionRedisKey sessionKey = new SessionRedisKey("personCount");
    public static SessionRedisKey SESSION_KEY = new SessionRedisKey(7 * 24 * 60 * 60, "");
}
