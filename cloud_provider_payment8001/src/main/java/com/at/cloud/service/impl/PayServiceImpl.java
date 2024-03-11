package com.at.cloud.service.impl;

import com.at.cloud.entities.Pay;
import com.at.cloud.entities.dto.PayDTO;
import com.at.cloud.mapper.PayMapper;
import com.at.cloud.service.IPayService;
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
//        Integer currentPage = payPageBean.getCurrentPage();
//
//        Integer pageSize = payPageBean.getPageSize();
//
//        //创建新的PageBean对象
//        PageBean<Pay> pb = new PageBean<>();
//
//        pb.setCurrentPage(currentPage);
//        pb.setPageSize(pageSize);
//
//        Integer start = (currentPage - 1) * pageSize;
//        //分页构造器
//        IPage<Pay> page = new Page<>(start, pageSize);
//        payMapper.selectPage(page, null);
//        Long _totalRecords = page.getTotal();
//        Integer totalRecords = _totalRecords.intValue();
//        pb.setTotalRecords(totalRecords);
//
//        Long _totalPage = page.getPages();
//        Integer totalPage = _totalPage.intValue();
//        pb.setTotalPage(totalPage);
//        List<Pay> records = page.getRecords();
//        pb.setRecords(records);
        return payMapper.selectList(null);
    }

    @Override
    public List<Pay> getPayByCondition(PayDTO payDTO) {
        QueryWrapper<Pay> wrapper = new QueryWrapper<>();
        wrapper.eq("pay_no", payDTO.getPayNo());
        return payMapper.selectList(wrapper);
    }
}
