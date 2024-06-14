package com.at.cloud.controller;

import com.atguigu.cloud.common.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author shunpeng.hu
 * @date 2024/6/14 10:36
 */
@RestController
public class OrderAlibabaController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/payment/nacos/{id}")
    public ResultData<String> checkPaymentInfo(@PathVariable("id") Integer id) {
        String result = restTemplate.getForObject(serverURL + "/payment/alibaba/nacos/" + id, String.class);
        return ResultData.success(result + "\t" + "    我是OrderNacosController8083调用者");
    }
}
