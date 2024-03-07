package com.at.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Husp
 * @Date 2024/3/7 23:24
 */
@SpringBootApplication
@MapperScan("com.at.cloud.mapper")
public class CloudProviderPaymentApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPaymentApplication8001.class, args);
        System.out.println("swagger3地址：http:localhost:8001/swagger-ui/index.html");
    }
}