package com.jwt.sell.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 卖家信息
 * Created by jiwt
 * 2019-09-25 23:02
 */
@Data
@Entity
@Table(name = "seller_info")
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
