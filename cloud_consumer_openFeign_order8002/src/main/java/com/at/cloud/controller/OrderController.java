package com.at.cloud.controller;

import com.at.cloud.apis.PayFeignApis;
import com.at.cloud.common.ResultData;
import com.at.cloud.entities.dto.PayDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Husp
 * @Date 2024/3/12 22:12
 */
@Tag(name = "订单服务模块", description = "订单服务消费的CRUN")
@RestController
@RequestMapping("/consumer/pay")
public class OrderController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Resource
    private PayFeignApis payFeignApis;

    @Operation(tags = "新增", summary = "新增", description = "服务消费新增支付")
    @GetMapping("/add")
    public ResultData addPay(@Parameter PayDTO payDTO) {
        return payFeignApis.addPay(payDTO);
    }

    @Operation(tags = "查询单个", summary = "查询单个", description = "服务消费查询单个支付")
    @GetMapping("/selectOne/{id}")
    public ResultData getPayById(@PathVariable("id") @Parameter Long id) {
        return payFeignApis.getById(id);
    }

    @Operation(tags = "修改", summary = "修改", description = "服务消费修改支付")
    @GetMapping("/update")
    public ResultData updatePay(@Parameter PayDTO payDTO) {
        payFeignApis.updatePay(payDTO);
        return ResultData.success("修改成功");
    }

    @Operation(tags = "删除", summary = "删除", description = "服务消费删除支付")
    @GetMapping("/delete/{id}")
    public ResultData delete(@PathVariable("id") @Parameter Long id){
        payFeignApis.deletePay(id);
        return ResultData.success("删除成功");
    }

    @GetMapping("/checkHealth")
    public String checkHealthConsul() {
        return payFeignApis.checkHealthConsul();
    }

    @GetMapping("/dynamicDiscovery")
    public String discovery() {
        //动态获取服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("service = " + service);
        }

        //获取注册中心的服务实例
        List<ServiceInstance> paymentIntances = discoveryClient.getInstances("payment-service");
        if (paymentIntances != null && paymentIntances.size() > 0 ) {
            for (ServiceInstance paymentService : paymentIntances) {
                System.out.println("paymentService = " + paymentService.getServiceId() + "\t" + paymentService.getHost() + "\t" + paymentService.getPort() + "\t" + paymentService.getUri());
            }
        }
        return paymentIntances.get(0).getServiceId()+":"+paymentIntances.get(0).getPort();
    }

}
