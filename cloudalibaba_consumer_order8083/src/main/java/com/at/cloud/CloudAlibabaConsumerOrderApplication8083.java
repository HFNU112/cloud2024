package com.at.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shunpeng.hu
 * @date 2024/6/14 10:23
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudAlibabaConsumerOrderApplication8083 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConsumerOrderApplication8083.class, args);
    }
}