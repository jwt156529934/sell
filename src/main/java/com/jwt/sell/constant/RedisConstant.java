package com.jwt.sell.constant;

/**
 * redis常量
 * Created by jiwt
 * 2017-07-30 16:22
 */
public interface RedisConstant {

    String TOKEN_PREFIX = "token_%s";

    Integer EXPIRE = 7200;
}
