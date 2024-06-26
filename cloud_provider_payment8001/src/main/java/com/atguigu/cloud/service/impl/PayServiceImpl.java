package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.dto.PayDTO;
import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.service.IPayService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
        QueryWrapper<Pay> wrapper = new QueryWrapper<>();
        wrapper.eq("deleted", 0);
        return payMapper.selectList(wrapper);
    }

    @Override
    public List<Pay> getPayByCondition(PayDTO payDTO) {
        QueryWrapper<Pay> wrapper = new QueryWrapper<>();
        wrapper.eq("pay_no", payDTO.getPayNo());
        return payMapper.selectList(wrapper);
    }
}
