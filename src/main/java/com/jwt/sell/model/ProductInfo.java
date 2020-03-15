package com.jwt.sell.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author wuli涛涛
 * @Title: ProductCategory
 * @ProjectName sell
 * @Description: 商品实体类
 * @date 2020/3/1520:34
 */
@Entity
@DynamicUpdate
@Data
public class ProductInfo {

    /**
     * 商品id
     */
    @Id
    @GeneratedValue
    private String productId;

    /**
     * 商品名字
     */
    private String productName;

    /**
     * 单价
      */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String prodDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 状态,0:正常1：下架
     */
    private Integer productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;
}
