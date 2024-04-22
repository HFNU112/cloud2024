package com.atguigu.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: shunpeng.hu
 * @date: 2024/3/22 16:26
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public Retryer retryer(){
//        Retryer.Default retryer = new Retryer.Default(100, 1, 3);// 初始间隔时间为100ms，重试间最大间隔时间为1s, 重试的最大请求次数3
        return Retryer.NEVER_RETRY;
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
