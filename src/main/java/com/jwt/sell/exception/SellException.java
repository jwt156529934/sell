package com.jwt.sell.exception;

import com.jwt.sell.enums.ResultEnum;

/**
 * @author wuli涛涛
 * @Title: SellException
 * @ProjectName sell
 * @Description: 异常处理类
 * @date 2020/3/1622:18
 */
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
