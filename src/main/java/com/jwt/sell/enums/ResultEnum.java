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
    PARAM_ERROR(30,"参数错误"),
    ORDER_NOT_EXIST(40,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(50,"订单详情不存在"),
    ORDER_STATUS_ERROR(60,"订单状态不正确"),
    ORDER_UPDATE_FAIL(70,"订单更新失败"),
    ORDER_DETAIL_EMPTY(80,"订单更新失败"),
    ORDER_PAY_STATUS_ERROR(90,"订单支付状态不正确"),
    CART_EMPTY(100,"购物车不能为空"),
    ORDER_OWNER_ERROR(101,"该订单不属于当前用户")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
