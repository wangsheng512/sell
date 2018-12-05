package com.wsheng.form;

import lombok.Data;

/**
 * @Auther: wsheng
 * @Date: 2018/8/27 21:59
 * @Description:
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}

