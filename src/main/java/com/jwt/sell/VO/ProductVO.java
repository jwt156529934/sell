package com.jwt.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品(包含类目)
 * Created by jiwt
 * 2019-09-25 14:13
 */
@Data
public class ProductVO implements Serializable {


    private static final long serialVersionUID = 861368503753984907L;
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
