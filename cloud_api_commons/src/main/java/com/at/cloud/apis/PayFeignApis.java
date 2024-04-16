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
public interface PayFeignApis {

    @PostMapping("/provider/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);

    @DeleteMapping("/provider/pay/delete/{id}")
    public ResultData deletePay(@PathVariable("id") Long id);

    @PutMapping("/provider/pay/update")
    public ResultData updatePay(@RequestBody PayDTO payDTO);

    @GetMapping("/provider/pay/selectOne/{id}")
    public ResultData getById(@PathVariable("id") Long id);

    @GetMapping("/provider/pay/selectAll")
    public ResultData getAll();

    @GetMapping("/provider/pay/checkHealth")
    public String checkHealthConsul();

    @GetMapping("/pay/micrometer/{id}")
    public ResultData<String> checkMicrometerHealth(@PathVariable(value = "id") Integer id);
}
