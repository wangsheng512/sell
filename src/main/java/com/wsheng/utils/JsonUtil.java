package com.wsheng.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * json 工具类
 */
public class JsonUtil {


    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
