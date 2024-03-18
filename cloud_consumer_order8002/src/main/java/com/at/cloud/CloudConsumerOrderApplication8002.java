package com.at.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author Husp
 * @Date 2024/3/12 21:57
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient  // 开启服务发现
public class CloudConsumerOrderApplication8002 {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(CloudConsumerOrderApplication8002.class, args);
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