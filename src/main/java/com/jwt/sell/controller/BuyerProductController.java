package com.jwt.sell.controller;

import com.jwt.sell.VO.ProductInfoVO;
import com.jwt.sell.VO.ProductVO;
import com.jwt.sell.VO.ResultVO;
import com.jwt.sell.model.ProductCategory;
import com.jwt.sell.model.ProductInfo;
import com.jwt.sell.service.ProductCategoryService;
import com.jwt.sell.service.ProductInfoService;
import com.jwt.sell.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
@Api(value="买家端商品接口",description = "买家端商品接口，提供买家端商品的展示接口")
public class BuyerProductController {
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @ApiOperation("按分类查询上架商品列表")
    @GetMapping("/list")
    public ResultVO list(){
        //1. 查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //2.查询分类方法
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
