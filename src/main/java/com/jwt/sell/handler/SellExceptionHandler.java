package com.jwt.sell.handler;

import com.jwt.sell.VO.ResultVO;
import com.jwt.sell.config.ProjectUrlConfig;
import com.jwt.sell.exception.SellException;
import com.jwt.sell.exception.SellerAuthorizeException;
import com.jwt.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jiwt
 * 2017-07-30 17:44
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    //http://sell.natapp4.cc/sell/wechat/qrAuthorize?returnUrl=http://sell.natapp4.cc/sell/seller/login
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:/");
//        .concat(projectUrlConfig.getWechatOpenAuthorize())
//        .concat("/sell/wechat/qrAuthorize")
//        .concat("?returnUrl=")
//        .concat(projectUrlConfig.getSell())
//        .concat("/sell/seller/login"));
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
//    @ResponseStatus(value = HttpStatus.FORBIDDEN) //返回HTTP状态码改变
    public ResultVO handlerSelleException(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }
}