package com.jwt.sell.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author wuli涛涛
 * @Title: ProductCategory
 * @ProjectName sell
 * @Description: 类目实体类
 * @date 2020/3/1520:34
 */
@Table(name = "product_category")
@Entity
@DynamicUpdate
@Data
public class ProductCategory  {

    /**
     * 类目id
     */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /**
     * 类目名字
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
