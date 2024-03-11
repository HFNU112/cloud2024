<template>
  <div>
    <div>
      <el-button plain @click="dialogFormVisible = true">
        新增
      </el-button>

      <el-dialog v-model="dialogFormVisible" title="新增支付信息" width="500">
        <el-form :model="form">
          <el-form-item label="支付流水号" :label-width="formLabelWidth">
            <el-input v-model="form.name" autocomplete="off" />
          </el-form-item>
          <el-form-item label="订单流水号" :label-width="formLabelWidth">
            <el-input v-model="form.name" autocomplete="off" />
          </el-form-item>
          <el-form-item label="用户id" :label-width="formLabelWidth">
            <el-select v-model="form.region" placeholder="please select your zone" autocomplete="off">
              <el-option label="1" value="shanghai" />
              <el-option label="2" value="beijing" />
            </el-select>
          </el-form-item>
          <el-form-item label="交易金额" :label-width="formLabelWidth">
            <el-input v-model="form.name" autocomplete="off" />
          </el-form-item>
        </el-form>
        <template #footer>
          <div class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取消</el-button>
            <el-button type="primary" @click="dialogFormVisible = false">
              保存
            </el-button>
          </div>
        </template>
      </el-dialog>
    </div>

    <br />

    <br />
    <el-table :data="payList.data" border style="width: 100%">
      <el-table-column prop="createTime" label="创建时间" width="200"></el-table-column>
      <el-table-column prop="payNo" label="支付流水号" width="150"></el-table-column>
      <el-table-column prop="orderNo" label="订单流水号" width="150"></el-table-column>
      <el-table-column prop="userId" label="用户id" width="90"></el-table-column>
      <el-table-column prop="amount" label="交易金额" width="120"></el-table-column>
      <el-table-column fixed="right" label="操作" width="240">
        <template #default>
          <el-button link type="primary" size="small" @click="selectOneHandle">详情</el-button>
          <el-button link type="primary" size="small">编辑</el-button>
          <el-button link type="primary" size="small" @click='delectHandleById'>删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <br>

    <!-- <table border="1 solid" aria-colspan="0" cellpadding="0">
      <tr>
        <th>支付流水号</th>
        <th>订单流水号</th>
        <th>用户id</th>
        <th>交易金额</th>
        <th>创建时间</th>
        <th>操作</th>
      </tr>
      <tr v-for="(pay, index) in payList.data">
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
    </table> -->
  </div>
</template>

<script setup>
// 导入api接口的js文件
import { payServiceSelectAll, payServiceSelectCondition } from '@/api/pay.js';
import { reactive, ref } from 'vue';
import {ElMessage, ElMessageBox} from 'element-plus';

//定义响应式数据
const payList = ref([])
const currentPage1 = ref(1)
const pageSize1 = ref(10)

// 获取数据
// 调用同步获取数据的函数网络请求 await async
const getAllPay = async function () {
  payList.value = await payServiceSelectAll();
}

// 调用函数
getAllPay();

// 定义响应式搜索数据
const searchConditon = ref({
  id: 1,
  payNo: '',
  orderNo: '',
  userId: '',
  amount: ''
})

// 搜索绑定条件事件触发
const selectOneHandle = async function (id) {
  console.log(id);
  //查询单条记录
  payList.value = await payServiceSelectCondition(id);
}

const dialogTableVisible = ref(false)
const dialogFormVisible = ref(false)
const formLabelWidth = '140px'

const form = reactive({
  name: '',
  region: '',
  date1: '',
  date2: '',
  delivery: false,
  type: [],
  resource: '',
  desc: '',
})

const gridData = [
  {
    date: '2016-05-02',
    name: 'John Smith',
    address: 'No.1518,  Jinshajiang Road, Putuo District',
  },
  {
    date: '2016-05-04',
    name: 'John Smith',
    address: 'No.1518,  Jinshajiang Road, Putuo District',
  },
  {
    date: '2016-05-01',
    name: 'John Smith',
    address: 'No.1518,  Jinshajiang Road, Putuo District',
  },
  {
    date: '2016-05-03',
    name: 'John Smith',
    address: 'No.1518,  Jinshajiang Road, Putuo District',
  },
]

// 删除事件触发
const delectHandleById = async function (id) {
  ElMessageBox.confirm(
    '确定删除么?',
    'Warning',
    {
      confirmButtonText: 'OK',
      cancelButtonText: 'Cancel',
      type: 'warning',
    }
  )
    .then(() => {
      ElMessage({
        type: 'success',
        message: '删除成功',
      })
    })
    .catch(() => {
      ElMessage({
        type: 'info',
        message: 'Delete canceled',
      })
    })
}

</script>

<style scoped></style>
