package com.jwt.sell.utils;

import com.jwt.sell.enums.CodeEnum;

/**
 * Created by jiwt
 * 2019-09-25 16:31
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
