package com.at.cloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 支付表
 * </p>
 *
 * @author shunpeng.hu
 * @since 2024-03-08
 */
@Schema(title = "支付表")
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("tb_pay")
public class Pay implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 支付流水号
     */
    @Schema(name = "支付流水号")
    private String payNo;

    /**
     * 订单流水号
     */
    @Schema(name = "订单流水号")
    private String orderNo;

    /**
     * 用户id
     */
    @Schema(name = "用户id")
    private Long userId;

    /**
     * 交易金额
     */
    @Schema(name = "交易金额")
    private BigDecimal amount;

    /**
     * 删除标识 0：不删除，1：删除
     */
    @Schema(name = "删除标识")
    @TableLogic
    private Byte deleted;

    /**
     * 创建时间
     */
    @Schema(name = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @Schema(name = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
