package com.wsheng.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http 请求返回的前段的对象（最外层的对象）
 */
@Data
public class ResultVO<T> implements Serializable{

    // shirft + i
    private static final long serialVersionUID = 4009766300595277425L;

    /**
     * 错误码
     */
     private Integer code;

    /** 提示信息
     *
     */
    private String msg;

    /**
     * 具体内容
     */
     private  T data;
}
