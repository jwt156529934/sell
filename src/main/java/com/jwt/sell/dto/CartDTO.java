package com.jwt.sell.dto;

import lombok.Data;

/**
 * @author wuli涛涛
 * @Title: OrderDTO
 * @ProjectName sell
 * @date 2020/3/1621:51
 */
@Data
public class CartDTO{

    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
