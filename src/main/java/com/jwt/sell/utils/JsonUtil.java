package com.jwt.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * json工具类
 * Created by jiwt
 * 2019-09-25 16:31
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
