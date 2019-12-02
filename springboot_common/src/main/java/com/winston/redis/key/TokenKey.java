package com.winston.redis.key;

/**
 * @author weigaosheng
 * @description
 * @CalssName UserKey
 * @date 2019/3/4
 * @params
 * @return
 */
public class TokenKey extends BasePrefix {

    private TokenKey(int expireSeconds, String preFix) {
        super(expireSeconds, preFix);
    }

    private TokenKey(String preFix) {
        super(preFix);
    }


    public static TokenKey LOGINTOKEN = new TokenKey(7 * 24 * 60 * 60, "loginToken");

}
