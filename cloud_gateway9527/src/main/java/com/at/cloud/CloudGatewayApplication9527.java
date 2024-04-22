package com.at.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: shunpeng.hu
 * @date: 2024/4/22 14:45
 */
@SpringBootApplication
@EnableDiscoveryClient //服务注册和发现
public class CloudGatewayApplication9527 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApplication9527.class, args);
    }
}