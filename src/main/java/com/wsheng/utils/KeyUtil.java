package com.wsheng.utils;

import java.util.Random;

/**
 * 生成随机数的方法
 */
public class KeyUtil {

    /***
     * 生成唯一的主键
     * 格式：时间+随机数
     *synchronized(多线程并发)
     */
    public  static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
