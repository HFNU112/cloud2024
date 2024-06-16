package com.at.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shunpeng.hu
 * @date 2024/6/13 14:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaProviderPaymentApplicatiion9001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaProviderPaymentApplicatiion9001.class, args);
    }
}