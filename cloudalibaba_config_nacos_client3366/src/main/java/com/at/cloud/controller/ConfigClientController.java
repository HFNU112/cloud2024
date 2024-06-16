package com.at.cloud.controller;

import com.atguigu.cloud.common.ResultData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author shunpeng.hu
 * @date 2024/6/14 14:19
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/nacos/config/checkHealth")
    public ResultData<String> checkHealthNacos(@Value("${atguigu.info}") String atInfo, @Value("${logging.pattern.dateformat}") String dateformat) {
        return ResultData.success(LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat)) + "\t" + "atInfo: " + atInfo + "\t" + "port: " + port);
    }
}
