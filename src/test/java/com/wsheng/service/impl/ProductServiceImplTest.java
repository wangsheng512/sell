package com.wsheng.service.impl;

import com.wsheng.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;


    @Test
    public void findOne() throws Exception {

        ProductInfo productInfo = productService.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> productInfos = productService.findAll(pageRequest);
//        System.out.println(productInfos.getTotalElements());
        Assert.assertNotEquals(0,productInfos.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123666");
        productInfo.setProductName("java学习资料");
        productInfo.setProductPrice(new BigDecimal(9.9));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("就业班的学习资料");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

}