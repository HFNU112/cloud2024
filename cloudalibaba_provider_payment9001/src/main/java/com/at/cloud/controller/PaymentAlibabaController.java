package com.at.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shunpeng.hu
 * @date 2024/6/13 14:56
 */
@RestController
public class PaymentAlibabaController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/alibaba/nacos/{id}")
    public String checkPaymentAlibabaInfo(@PathVariable(value = "id") Integer id) {
        return "nacos registry, serverPort: " + serverPort + "\t id" + id;
    }
}
