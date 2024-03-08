package com.at.cloud;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author Husp
 * @Date 2024/3/7 23:24
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.at.cloud.mapper")
public class CloudProviderPaymentApplication8001 {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(CloudProviderPaymentApplication8001.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
//        System.out.println("swagger3地址：http:localhost:8001/swagger-ui/index.html");

        log.info("\n----------------------------------------------------------\n\t" +
                "Application Jeecg-Boot is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + "/\n\t" +
                "Swagger3文档: \thttp://" + ip + ":" + port + "/swagger-ui/index.html\n" +
                "----------------------------------------------------------");
    }
}