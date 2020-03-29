package com.jwt.sell.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * Created by jiwt
 * 2019-09-25 14:13
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 5548375132257523125L;

    /** 错误码. */
    //站点id
    @ApiModelProperty("错误码")
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
