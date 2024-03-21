package com.at.cloud.apis;

import com.at.cloud.common.ResultData;
import com.at.cloud.entities.dto.PayDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author: shunpeng.hu
 * @date: 2024/3/21 17:30
 */
@FeignClient(value = "payment-service")
@RequestMapping("/openFeign/provider/pay")
public interface PayFeignApis {

    @PostMapping("/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);

    @DeleteMapping("/delete/{id}")
    public ResultData deletePay(@PathVariable("id") Long id);

    @PutMapping("/update")
    public ResultData updatePay(@RequestBody PayDTO payDTO);

    @GetMapping("/selectOne/{id}")
    public ResultData getById(@PathVariable("id") Long id);

    @GetMapping("/selectAll")
    public ResultData getAll();

    @GetMapping("/checkHealth")
    public String checkHealthConsul();

}
