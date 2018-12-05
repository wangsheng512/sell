package com.wsheng.utils;


import com.wsheng.enums.CodeEnum;

/**
 *
 * wsheng
 * enum 工具类
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }

}
