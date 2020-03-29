package com.jwt.sell.repository.mapper;

import com.jwt.sell.model.ProductCategory;
import com.jwt.sell.model.SellerInfo;
import org.apache.ibatis.annotations.Select;

/**
 * @author wuli涛涛
 * @Title: ProductCategoryMapper
 * @ProjectName sell
 * @Description: 使用mybatis增删改差
 * @date 2020/3/2822:46
 */
public interface ProductCategoryMapper {

    @Select("select * from product_category where category_type = #{categoryType}")
    ProductCategory findAll(Integer categoryType);

    @Select("select * from seller_info where id = #{id}")
    SellerInfo findSeller(Integer id);
}
