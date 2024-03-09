// 1. 导入axios依赖
import axios from 'axios';
// 定义统一的变量地址
const baseURL = 'http://localhost:8001';
const instance = axios.create({baseURL});

// 添加响应拦截器
instance.interceptors.response.use((result) => {
    // 2xx 范围内的状态码都会触发该函数。
    // 处理成功情况
    return result.data;
}, (error) => {
    // 超出 2xx 范围的状态码都会触发该函数。
    // 对响应错误做点什么
    alert("服务异常~")
    return Promise.reject(error); // 异步状态转换成失败的状态
});

// 暴漏给外部
export default instance;
