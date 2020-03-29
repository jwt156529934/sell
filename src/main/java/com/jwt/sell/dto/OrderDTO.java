package com.jwt.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jwt.sell.enums.OrderStatusEnum;
import com.jwt.sell.enums.PayStatusEnum;
import com.jwt.sell.model.OrderDetail;
import com.jwt.sell.model.OrderMaster;
import com.jwt.sell.utils.EnumUtil;
import lombok.Data;

import java.io.Serializable;
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
public class OrderDTO extends OrderMaster implements Serializable {

    private static final long serialVersionUID = 8733068494898243321L;
    //    @JsonIgnore
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(super.getOrderStatus(), OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(super.getPayStatus(), PayStatusEnum.class);
    }
}
