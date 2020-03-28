package com.jwt.sell.repository;

import com.jwt.sell.model.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wuli涛涛
 * @Title: ProductCategoryRepository
 * @ProjectName sell
 * @date 2020/3/1520:38
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}

