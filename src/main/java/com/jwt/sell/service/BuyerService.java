package com.jwt.sell.service;

import com.jwt.sell.dto.OrderDTO;

/**
 * @author wuli涛涛
 * @Title: BuyerService
 * @ProjectName sell
 * @Description: TODO
 * @date 2020/3/1821:29
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
