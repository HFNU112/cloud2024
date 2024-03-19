package com.at.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: shunpeng.hu
 * @date: 2024/3/19 10:59
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient  // 开启服务发现
public class CloudConsumerFeignOrderApplication8002 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignOrderApplication8002.class, args);
    }
}