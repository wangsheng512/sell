package com.wsheng.repository;

import com.wsheng.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

        @Autowired
        private ProductCategoryRepository productCategoryRepository;


        @Test
        public void findOneTest(){
                ProductCategory productCategory = productCategoryRepository.findOne(1);
                System.out.println(productCategory.toString());

        }

        @Test
        public void saveTest(){
             ProductCategory productCategory = new ProductCategory("我最爱",3);
             ProductCategory result = productCategoryRepository.save(productCategory);
             //断言
            Assert.assertNotNull(result);
            //Assert.assertNotEquals(null,result);
        }
}