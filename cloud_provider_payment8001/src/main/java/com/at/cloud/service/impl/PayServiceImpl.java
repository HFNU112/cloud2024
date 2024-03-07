package com.at.cloud.service.impl;

import com.at.cloud.entities.Pay;
import com.at.cloud.mapper.PayMapper;
import com.at.cloud.service.IPayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 支付表 服务实现类
 * </p>
 *
 * @author shunpeng.hu
 * @since 2024-03-08
 */
@Service
public class PayServiceImpl extends ServiceImpl<PayMapper, Pay> implements IPayService {

    @Resource
    private PayMapper payMapper;

    @Override
    public int addPay(Pay pay) {
        return payMapper.insert(pay);
    }

    @Override
    public Integer deletePay(Long id) {
        return payMapper.deleteById(id);
    }

    @Override
    public int updatePay(Pay pay) {
        return payMapper.update(pay, null);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectList(null);
    }
}
