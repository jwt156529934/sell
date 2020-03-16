package com.jwt.sell.repository;

import com.jwt.sell.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wuli涛涛
 * @Title: OrderDetailRepository
 * @ProjectName sell
 * @date 2020/3/1621:36
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

   List<OrderDetail> findByOrderId(String orderId);
}
