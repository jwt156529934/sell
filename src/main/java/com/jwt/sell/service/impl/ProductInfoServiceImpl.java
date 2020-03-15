package com.jwt.sell.service.impl;

import com.jwt.sell.enums.ProductStatusEnum;
import com.jwt.sell.model.ProductInfo;
import com.jwt.sell.repository.ProductInfoRepository;
import com.jwt.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author wuli涛涛
 * @Title: ProductCategoryServiceImpl
 * @ProjectName sell
 * @Description: TODO
 * @date 2020/3/1521:09
 */
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Override
    public List<ProductInfo> findByProductStatus(Integer productStatus) {
        return repository.findByProductStatus(productStatus);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
