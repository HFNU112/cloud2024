package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.common.ResultData;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.service.IPayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.protocol.HTTP;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Enumeration;

/**
 * @author: shunpeng.hu
 * date: 2024/4/22 15:05
 */
@Slf4j
@RestController
public class PayGateWayController {

    @Resource
    private IPayService payService;

    /**
     * 对外使用暴漏网关端口调用CRUD接口
     */
    @GetMapping("/provider/pay/gateway/info")
    public ResultData<String> checkHealthGatewayInfo() {
        return ResultData.success("gateway info test：" + IdUtil.randomUUID());
    }

    @GetMapping("/provider/pay/gateway/selectOne/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping("/provider/pay/gateway/filter")
    public ResultData<String> getGatewayFilter(HttpServletRequest request){
        String result = "";
        Enumeration<String> headers = request.getHeaderNames();
        while(headers.hasMoreElements())
        {
            String headName = headers.nextElement();
            String headValue = request.getHeader(headName);
            log.info("请求头名: {}", headName);
            log.info("请求头值:{}", headValue);
            if(headName.equalsIgnoreCase("X-Request-atValue1")
                    || headName.equalsIgnoreCase("X-Request-atValue2")) {
                result = result+headName + "\t " + headValue +" ";
                log.info("result:{}", result);
            }
        }

        String customerId = request.getParameter("customerId");
        log.info("customerId:{}", customerId);

        String customerName = request.getParameter("customerName");
        log.info("customerName:{}", customerName);
        return ResultData.success("getGatewayFilter 过滤器 test： "+result+" \t "+ LocalDateTime.now());
    }

}
