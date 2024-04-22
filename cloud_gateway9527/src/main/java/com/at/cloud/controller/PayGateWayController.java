package com.at.cloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: shunpeng.hu
 * @date: 2024/4/22 15:05
 */
@RestController
public class PayGateWayController {

    @GetMapping("/gateway/info")
    public String checkHealthGatewayInfo() {
        return "gateway info test：" + IdUtil.randomUUID();
    }

}
