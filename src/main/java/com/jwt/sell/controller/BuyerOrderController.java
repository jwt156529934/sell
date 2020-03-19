package com.jwt.sell.controller;

import com.jwt.sell.VO.ResultVO;
import com.jwt.sell.converter.OrderForm2OrderDTOConverter;
import com.jwt.sell.dto.OrderDTO;
import com.jwt.sell.enums.ResultEnum;
import com.jwt.sell.exception.SellException;
import com.jwt.sell.form.OrderForm;
import com.jwt.sell.service.BuyerService;
import com.jwt.sell.service.OrderService;
import com.jwt.sell.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Api(tags = "订单管理接口，订单的增删改查")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    /**
     * 创建订单
     * @param orderForm
     * @return
     */
    @PostMapping(value = "/create")
    @ApiOperation(value = "创建订单接口",notes ="方法的备注",httpMethod="POST")
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
     * @param openid
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                          @RequestParam(value = "page",defaultValue = "0") Integer page,
                                          @RequestParam(value = "size",defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);
        return ResultVOUtil.success(orderDTOPage.getContent());
    }
    /**
     * 查询订单详情
     * @param openid
     * @param orderId
     * @return
     */
    @GetMapping(value = "/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,@RequestParam("orderId") String orderId){
        OrderDTO order = buyerService.findOrderOne(openid,orderId);
        return ResultVOUtil.success(order);
    }


    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    @PostMapping(value = "/cancel")
    public ResultVO<OrderDTO> cancel(@RequestParam("openid") String openid,@RequestParam("orderId") String orderId){
        buyerService.cancelOrder(openid,orderId);
        return ResultVOUtil.success();
    }

    /**
     * 订单支付
     * @param orderDTO
     * @return
     */
}
