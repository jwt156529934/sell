package com.jwt.sell.dto;

import com.jwt.sell.model.OrderDetail;
import com.jwt.sell.model.OrderMaster;
import lombok.Data;

import java.util.List;

/**
 * @author wuli涛涛
 * @Title: OrderDTO
 * @ProjectName sell
 * @Description: TODO
 * @date 2020/3/1621:51
 */
@Data
public class OrderDTO extends OrderMaster {

    private List<OrderDetail> orderDetailList;
}
