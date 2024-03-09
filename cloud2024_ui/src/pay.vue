<template>
  <div>
    编号: <input type="text" placeholder="输入支付流水号" v-model="searchConditon.payNo">
    <button @click="searchHandler"> 搜索</button>
    <br/>
    <br/>
    <table border="1 solid" aria-colspan="0" cellpadding="0">
      <tr>
        <th>支付流水号</th>
        <th>订单流水号</th>
        <th>用户id</th>
        <th>交易金额</th>
        <th>创建时间</th>
        <th>操作</th>
      </tr>
      <tr v-for="(pay, index) in payList">
        <td>{{ pay.payNo }}</td>
        <td>{{ pay.orderNo }}</td>
        <td>{{ pay.userId }}</td>
        <td>{{ pay.amount }}</td>
        <td>{{ pay.createTime }}</td>
        <td>
          <button>编辑</button>
          <button>删除</button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script setup>
// 导入api接口的js文件
import {payServiceSelectAll, payServiceSelectCondition} from '@/api/pay.js';
import {ref} from 'vue';

//定义响应式数据
const payList = ref([])

// 获取数据
// 调用同步获取数据的函数网络请求 await async
const getAllPay = async function () {
  payList.value = await payServiceSelectAll();
}

// 调用函数
getAllPay();

// 定义响应式搜索数据
const searchConditon = ref({
  id: '',
  payNo: '',
  orderNo: '',
  userId: '',
  amount: ''
})

// 搜索绑定条件事件触发
const searchHandler = async function () {
  //查询单条记录
  payList.value = await payServiceSelectCondition({...searchConditon.value});
}

</script>

<style scoped>

</style>
