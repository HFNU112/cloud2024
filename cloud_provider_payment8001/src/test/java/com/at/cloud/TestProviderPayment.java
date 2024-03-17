package com.at.cloud;

import com.at.cloud.entities.Pay;
import com.at.cloud.service.IPayService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
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
    public void testGetAll() {
        List<Pay> payLists = payService.getAll();
        for (Pay pay : payLists) {
            System.out.println("pay = " + pay);
        }
    }

    @Test
    @Order(2)
    @DisplayName(value = "测试新增支付")
    public void testAddPay(){
        Pay pay = new Pay();
        pay.setPayNo("No.202403141001");
        pay.setOrderNo("No.202403142001");
        pay.setAmount(BigDecimal.valueOf(29.9));
        int row = payService.addPay(pay);
        System.out.println("row = " + row);
    }

    @Test
    @Order(3)
    @DisplayName(value = "测试删除支付")
    public void testDeletePay(){
        Long id = 12L;
        Integer row = payService.deletePay(id);
        System.out.println("row = " + row);
    }

    @Test
    @Order(4)
    @DisplayName(value = "测试修改支付")
    public void testUpdatePay(){
        Pay pay = new Pay();
        pay.setId(11L);
        pay.setPayNo("pay202403131001");
        pay.setOrderNo("pay202403132001");
        pay.setAmount(BigDecimal.valueOf(49.9));
        int row = payService.updatePay(pay);
        System.out.println("row = " + row);
    }

}
