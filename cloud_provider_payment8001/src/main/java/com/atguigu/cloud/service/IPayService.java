package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.dto.PayDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 支付表 服务类
 * </p>
 *
 * @author shunpeng.hu
 * @since 2024-03-08
 */
public interface IPayService extends IService<Pay> {

    int addPay(Pay pay);

    Integer deletePay(Long id);

    int updatePay(Pay pay);

    List<Pay> getAll();

    List<Pay> getPayByCondition(PayDTO payDTO);

}
