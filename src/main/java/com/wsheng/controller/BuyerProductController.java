package com.wsheng.controller;


import com.wsheng.VO.ProductInfoVO;
import com.wsheng.VO.ProductVO;
import com.wsheng.VO.ResultVO;
import com.wsheng.dataobject.ProductCategory;
import com.wsheng.dataobject.ProductInfo;
import com.wsheng.service.CategoryService;
import com.wsheng.service.ProductService;
import com.wsheng.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    public ResultVO list(){
        //查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //查询商品类目(精简的方法，java8 lambda)
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //数据封装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productCategory.getCategoryType().equals(productInfo.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO );
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

}
