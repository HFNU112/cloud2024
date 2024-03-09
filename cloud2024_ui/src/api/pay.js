// // 1. 导入axios依赖
// import axios from 'axios';
//
// // 定义统一的变量地址
// const baseURL = 'http://localhost:8001';
// const instance = axios.create({baseURL});
import request from '@/utils/requestjs.js'

// 获取所有的支付信息请求
export function payServiceSelectAll() {
    //2. 发送请求
    //因为异步请求需要同步等待服务器响应的结果并返回
    return request.get('/provider/pay/selectAll');
}

// 获取单条支付信息
export async function  payServiceSelectCondition(condition) {
    // 点击请求
    return await request.post('/provider/pay/selectByCondition', {params: condition});
}
