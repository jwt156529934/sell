package com.jwt.sell.repository;

import com.jwt.sell.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wuli涛涛
 * @Title: ProductCategoryRepository
 * @ProjectName sell
 * @Description: 商品持久层
 * @date 2020/3/1520:38
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
