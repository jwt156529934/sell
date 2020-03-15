package com.jwt.sell.repository;

import com.jwt.sell.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wuli涛涛
 * @Title: ProductCategoryRepository
 * @ProjectName sell
 * @Description: 商品类目持久层
 * @date 2020/3/1520:38
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
