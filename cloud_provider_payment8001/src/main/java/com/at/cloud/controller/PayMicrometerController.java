package com.at.cloud.controller;

import cn.hutool.core.lang.UUID;
import com.at.cloud.common.ResultData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: shunpeng.hu
 * @date: 2024/4/16 15:29
 */
public class PayMicrometerController {

    /**
     * 检查链路检控状态
     */
    @GetMapping("/pay/micrometer/{id}")
    public ResultData<String> checkMicrometerHealth(@PathVariable(value = "id") Integer id) {
        String result = "Hello, 欢迎到来myMicrometer inputId:  " + id + " \t    服务返回:" + UUID.randomUUID().toString(true);
        return ResultData.success(result);
    }
}
