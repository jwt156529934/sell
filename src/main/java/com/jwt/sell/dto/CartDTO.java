package com.jwt.sell.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wuli涛涛
 * @Title: OrderDTO
 * @ProjectName sell
 * @date 2020/3/1621:51
 */
@Data
public class CartDTO implements Serializable {

    private static final long serialVersionUID = 3717773652238259296L;
    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
