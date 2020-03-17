package com.jwt.sell.controller;

import com.jwt.sell.VO.ResultVO;
import com.jwt.sell.dto.OrderDTO;
import com.jwt.sell.service.OrderService;
import com.jwt.sell.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buyer/order")
@Api(value="订单管理接口",description = "订单管理接口，订单的增删改查")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    @PostMapping(value = "/create")
    @ApiImplicitParams({ @ApiImplicitParam(name="orderForm",value = "订单表单",required=true,paramType="path",dataType="int")})
    public ResultVO create(OrderDTO orderDTO){
        OrderDTO order = orderService.create(orderDTO);
        return  ResultVOUtil.success();
    }
}
