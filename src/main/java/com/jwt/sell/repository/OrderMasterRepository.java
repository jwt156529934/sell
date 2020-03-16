package com.jwt.sell.repository;

import com.jwt.sell.model.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wuli涛涛
 * @Title: OrderMasterRepository
 * @ProjectName sell
 * @date 2020/3/1621:36
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

   Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
