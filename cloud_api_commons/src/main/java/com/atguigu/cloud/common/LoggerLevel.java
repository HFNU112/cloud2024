package com.atguigu.cloud.common;

/**
 * @author: shunpeng.hu
 * @date: 2024/3/22 16:34
 */
public enum LoggerLevel {

    /**
     * 不记录（默认）
     */
    NONE,

    /**
     * 仅记录请求方法和URL以及响应状态码和执行时间
     */
    BASIC,

    /**
     * 记录基本信息以及请求和响应标头
     */
    HEADERS,

    /**
     * 记录请求和响应的标头、正文和元数据
     */
    FULL
}
