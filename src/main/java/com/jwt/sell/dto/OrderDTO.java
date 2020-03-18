package com.jwt.sell.dto;

import com.jwt.sell.model.OrderDetail;
import com.jwt.sell.model.OrderMaster;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuli涛涛
 * @Title: OrderDTO
 * @ProjectName sell
 * @date 2020/3/1621:51
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO extends OrderMaster {

//    @JsonIgnore
    private List<OrderDetail> orderDetailList = new ArrayList<>();
}
