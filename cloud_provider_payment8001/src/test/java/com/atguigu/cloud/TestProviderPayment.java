package com.atguigu.cloud;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.service.IPayService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: shunpeng.hu
 * @date: 2024/3/8 11:10
 */
@SpringBootTest(classes = CloudProviderPaymentApplication8001.class)
public class TestProviderPayment {

    @Autowired
    private IPayService payService;

    @Test
    @Order(1)
    @DisplayName(value = "测试查询所有支付信息")
    void testGetAll() {
        List<Pay> payList = payService.getAll();
        for (int i = 0; i < payList.size(); i++) {
            Pay pay = payList.get(0);
            Assertions.assertEquals("pay202403080021001", pay.getPayNo());
        }
    }

    @Test
    @Order(2)
    @DisplayName(value = "测试新增支付")
    public void testAddPay() {
        Pay pay = new Pay();
        pay.setPayNo("F2024051717201001");
        pay.setOrderNo("D2024051717202001");
        pay.setAmount(BigDecimal.valueOf(99.9));
        int row = payService.addPay(pay);
        Assertions.assertEquals(1, row);
    }

    @Test
    @Order(3)
    @DisplayName(value = "测试删除支付")
    public void testDeletePay() {
        Long id = 11L;
        Integer row = payService.deletePay(id);
        Assertions.assertEquals(1, row);
    }

    @Test
    @Order(4)
    @DisplayName(value = "测试修改支付")
    public void testUpdatePay() {
        Pay pay = new Pay();
        pay.setId(11L);
        pay.setAmount(BigDecimal.valueOf(49.9));
        int row = payService.updatePay(pay);
        Assertions.assertEquals(1, row);
    }

}
