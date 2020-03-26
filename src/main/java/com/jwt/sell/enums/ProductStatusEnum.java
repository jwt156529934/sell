package com.jwt.sell.enums;

import lombok.Getter;

/**
 * @author wuli涛涛
 * @Title: ProductStatusEnum
 * @ProjectName sell
 * @date 2020/3/1521:36
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}
