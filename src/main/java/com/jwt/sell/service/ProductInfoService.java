package com.jwt.sell.service;

import com.jwt.sell.dto.CartDTO;
import com.jwt.sell.model.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author wuli涛涛
 * @Title: ProductCategoryService
 * @ProjectName sell
 * @Description: 商品类目service层
 * @date 2020/3/1520:53
 */
public interface ProductInfoService {

    ProductInfo findOne(String ProductId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    List<ProductInfo> findByProductStatus(Integer productStatus);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

}
