package com.jwt.sell.enums;

import lombok.Getter;

/**
 * Created by jiwt
 * 2019-09-25 18:16
 */
@Getter
public enum ResultEnum implements CodeEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(20,"库存不正确"),
    PARAM_ERROR(30,"参数错误")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
