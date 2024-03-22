package com.at.cloud.controller;

import com.at.cloud.apis.PayFeignApis;
import com.at.cloud.common.ResultCodeEnum;
import com.at.cloud.common.ResultData;
import com.at.cloud.entities.dto.PayDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @Author Husp
 * @Date 2024/3/12 22:12
 */
@Tag(name = "订单服务模块", description = "订单服务消费的CRUN")
@RestController
@RequestMapping("/feign/consumer/pay")
public class OrderController {

    @Resource
    private PayFeignApis payFeignApis;

    @Operation(tags = "新增", summary = "新增", description = "服务消费新增支付")
    @PostMapping("/add")
    public ResultData addPay(@RequestBody @Parameter PayDTO payDTO) {
        return payFeignApis.addPay(payDTO);
    }

    @Operation(tags = "查询单个", summary = "查询单个", description = "服务消费查询单个支付")
    @GetMapping("/selectOne/{id}")
    public ResultData getPayById(@PathVariable("id") @Parameter Long id) {
        ResultData resultData = null;
        try {
            System.out.println("开始执行-------------" + LocalDateTime.now());
            resultData = payFeignApis.getById(id);
        } catch (Exception e) {
            System.out.println("执行结束----------" + LocalDateTime.now());
            return ResultData.fail(ResultCodeEnum.RC500.getCode(), e.getMessage());
        }
        return resultData;
    }

    @Operation(tags = "修改", summary = "修改", description = "服务消费修改支付")
    @PutMapping("/update")
    public ResultData updatePay(@RequestBody @Parameter PayDTO payDTO) {
        payFeignApis.updatePay(payDTO);
        return ResultData.success("修改成功");
    }

    @Operation(tags = "删除", summary = "删除", description = "服务消费删除支付")
    @DeleteMapping("/delete/{id}")
    public ResultData delete(@PathVariable("id") @Parameter Long id) {
        payFeignApis.deletePay(id);
        return ResultData.success("删除成功");
    }

    @GetMapping("/getAll")
    public ResultData getPayAll(){
        ResultData payList = payFeignApis.getAll();
        return ResultData.success(payList);
    }

    @GetMapping("/checkHealth")
    public String checkHealthConsul() {
        return payFeignApis.checkHealthConsul();
    }

}
