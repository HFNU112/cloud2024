package com.at.cloud.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author Husp
 * @Date 2024/3/8 0:55
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayDTO implements Serializable {

    private Long id;

    //支付流水号
    private String payNo;

    //订单流水号
    private String orderNo;

    //用户账号ID
    private Long userId;

    //交易金额
    private BigDecimal amount;
}
