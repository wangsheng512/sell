package com.wsheng.service.impl;

import com.wsheng.dto.OrderDTO;
import com.wsheng.service.OrderService;
import com.wsheng.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1532527606358308778");
        payService.create(orderDTO);
    }

    @Test
    public void refund() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1534777369880261605");
        payService.refund(orderDTO);
    }
}