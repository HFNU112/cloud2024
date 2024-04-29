package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApis;
import com.atguigu.cloud.common.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Husp
 * date 2024/4/29 21:46
 */
@RestController
public class OrderGateWayController {

    @Resource
    private PayFeignApis payFeignApis;

    /**
     * 内部环境通过服务消费者调用服务提供者
     */
    @GetMapping("/feign/pay/gateway/selectOne/{id}")
    public ResultData getById(@PathVariable(value = "id") Integer id){
        return payFeignApis.getById(id);
    }

    @GetMapping("/feign/pay/gateway/info")
    public ResultData<String> checkHealthGatewayInfo(){
        return payFeignApis.checkHealthGatewayInfo();
    }
}
