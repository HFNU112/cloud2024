package com.atguigu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: shunpeng.hu
 * @date: 2024/3/19 10:59
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient  // 开启服务发现
@EnableFeignClients    // 开启feign远程调用
public class CloudConsumerFeignOrderApplication8002 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignOrderApplication8002.class, args);
    }
}