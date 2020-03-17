package com.jwt.sell.controller;

import com.jwt.sell.VO.ResultVO;
import com.jwt.sell.converter.OrderForm2OrderDTOConverter;
import com.jwt.sell.dto.OrderDTO;
import com.jwt.sell.enums.ResultEnum;
import com.jwt.sell.exception.SellException;
import com.jwt.sell.form.OrderForm;
import com.jwt.sell.service.OrderService;
import com.jwt.sell.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Api(value="订单管理接口",description = "订单管理接口，订单的增删改查")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param orderForm
     * @return
     */
    @PostMapping(value = "/create")
    @ApiImplicitParams({ @ApiImplicitParam(name="orderForm",value = "订单表单",required=true,paramType="path",dataType="int")})
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】 参数不正确 orderForm={}",orderForm);
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        HashMap<String,String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return  ResultVOUtil.success(map);
    }

    /**
     * 订单列表
     * @param orderDTO
     * @return
     */

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
}
