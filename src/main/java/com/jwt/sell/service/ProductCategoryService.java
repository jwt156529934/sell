package com.jwt.sell.service;

import com.jwt.sell.model.ProductCategory;

import java.util.List;

/**
 * @author wuli涛涛
 * @Title: ProductCategoryService
 * @ProjectName sell
 * @Description: 商品类目service层
 * @date 2020/3/1520:53
 */
public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
