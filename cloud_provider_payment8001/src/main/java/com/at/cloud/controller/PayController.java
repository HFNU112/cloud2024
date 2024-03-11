package com.at.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.at.cloud.common.ResultData;
import com.at.cloud.entities.Pay;
import com.at.cloud.entities.dto.PayDTO;
import com.at.cloud.service.IPayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 支付表 前端控制器
 * </p>
 *
 * @author shunpeng.hu
 * @since 2024-03-08
 */
@Tag(name = "支付服务模块", description = "支付服务CRUD")
@CrossOrigin // 跨域解决方法
@RestController
@RequestMapping("/provider/pay")
public class PayController {

    @Resource
    private IPayService payService;

    @Operation(tags = "新增", summary = "新增", description = "新增支付")
    @PostMapping("/add")
    public ResultData<String> addPay(@RequestBody @Parameter Pay pay){
        int row = payService.addPay(pay);
        return ResultData.success("新增成功，受影响行数：" + row);
    }

    @Operation(tags = "删除", summary = "删除", description = "删除支付")
    @DeleteMapping("/delete/{id}")
    public ResultData<Integer> deletePay(@PathVariable("id") @Parameter Long id){
        Integer i = payService.deletePay(id);
        return ResultData.success(i);
    }

    @Operation(tags = "修改",summary = "修改", description = "修改支付")
    @PutMapping("/update")
    public ResultData<String> updatePay(@RequestBody @Parameter PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO,  pay);
        int row = payService.updatePay(pay);
        return ResultData.success("修改成功，受影响行数：" + row);
    }

    @Operation(tags = "查询单个", summary = "查询单个", description = "查询单条支付信息")
    @GetMapping("/selectOne/{id}")
    public ResultData<Pay> getById(@PathVariable("id") @Parameter Long id){
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @Operation(tags = "查询所有", summary = "查询所有", description = "查询所有支付")
    @GetMapping("/selectAll")
    public ResultData<List<Pay>> getAll(){
        List<Pay> payList = payService.getAll();
        return ResultData.success(payList);
    }

    @Operation(summary = "条件查询", description = "查询指定条件的支付信息")
    @PostMapping("/selectByCondition")
    public List<Pay> getPayByCondition(@RequestBody @Parameter PayDTO payDTO){
        return payService.getPayByCondition(payDTO);
    }
}
