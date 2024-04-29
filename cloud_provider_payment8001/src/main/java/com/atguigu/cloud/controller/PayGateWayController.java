package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.common.ResultData;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.service.IPayService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: shunpeng.hu
 * date: 2024/4/22 15:05
 */
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

}
