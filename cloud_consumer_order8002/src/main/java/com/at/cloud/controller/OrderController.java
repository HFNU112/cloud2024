package com.at.cloud.controller;

import com.at.cloud.common.ResultData;
import com.at.cloud.constant.SystemConstant;
import com.at.cloud.entities.dto.PayDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Husp
 * @Date 2024/3/12 22:12
 */
@Tag(name = "订单服务模块", description = "订单服务消费的CRUN")
@RestController
@RequestMapping("/consumer/pay")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Operation(tags = "新增", summary = "新增", description = "服务消费新增支付")
    @GetMapping("/add")
    public ResultData addPay(@Parameter PayDTO payDTO) {
        return restTemplate.postForObject(SystemConstant.PAYMENT_APPLICATION_URL + "/provider/pay/add", payDTO, ResultData.class);
    }

    @Operation(tags = "查询单个", summary = "查询单个", description = "服务消费查询单个支付")
    @GetMapping("/selectOne/{id}")
    public ResultData getPayById(@PathVariable("id") @Parameter Long id) {
        return restTemplate.getForObject(SystemConstant.PAYMENT_APPLICATION_URL + "/provider/pay/selectOne/" + id, ResultData.class, id);
    }

    @Operation(tags = "修改", summary = "修改", description = "服务消费修改支付")
    @GetMapping("/update")
    public ResultData updatePay(@Parameter PayDTO payDTO) {
        restTemplate.put(SystemConstant.PAYMENT_APPLICATION_URL + "/provider/pay/update", payDTO);
        return ResultData.success("修改成功");
    }

    @Operation(tags = "删除", summary = "删除", description = "服务消费删除支付")
    @GetMapping("/delete/{id}")
    public ResultData delete(@PathVariable("id") @Parameter Long id){
        restTemplate.delete(SystemConstant.PAYMENT_APPLICATION_URL + "/provider/pay/delete/"+id, id);
        return ResultData.success("删除成功");
    }

}
