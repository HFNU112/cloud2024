package com.at.cloud;

import com.at.cloud.entities.Pay;
import com.at.cloud.service.IPayService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    @DisplayName("查询所有支付信息")
    public void testGetAll() {
        List<Pay> payList = payService.getAll();
        for (Pay pay : payList) {
            System.out.println("pay = " + pay);
        }
    }

}
