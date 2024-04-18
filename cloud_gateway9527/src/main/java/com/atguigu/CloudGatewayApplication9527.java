package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: shunpeng.hu
 * @date: 2024/4/18 15:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudGatewayApplication9527 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApplication9527.class, args);
    }
}