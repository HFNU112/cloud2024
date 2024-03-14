<template>
  <div>
    <div>
      <el-button plain @click="dialogFormVisible = true; title = '新增支付信息'">
        新增
      </el-button>

      <el-dialog v-model="dialogFormVisible" :title="title" width="500">
        <el-form :model="payModel" :rules="rules">
          <el-form-item label="支付流水号" prop="payNo" :label-width="formLabelWidth">
            <el-input v-model="payModel.payNo" autocomplete="off" />
          </el-form-item>
          <el-form-item label="订单流水号" prop="orderNo" :label-width="formLabelWidth">
            <el-input v-model="payModel.orderNo" autocomplete="off" />
          </el-form-item>
          <el-form-item label="交易金额" prop="amount" :label-width="formLabelWidth">
            <el-input v-model="payModel.amount" autocomplete="off" />
          </el-form-item>
        </el-form>
        <template #footer>
          <div class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取消</el-button>
            <el-button type="primary" @click="addPay">
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
        <template #default="{ row }">
          <el-button link type="primary" size="small" @click="selectOneHandle">详情</el-button>
          <el-button link type="primary" size="small" @click="addOrEditPayDialog">编辑</el-button>
          <el-button link type="primary" size="small" @click="delectPayById(row)">删除</el-button>
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
import { payServiceSelectAll, payServiceSelectCondition, payServiceAdd, payServiceDelete } from '@/api/pay.js';
import { reactive, ref } from 'vue';
import { ElMessage, ElMessageBox } from 'element-plus';

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

//添加数据模型
const payModel = ref({
  payNo: '',
  orderNo: '',
  userId: 1,
  amount: ''
})

// 添加新增表单校验
const rules = {
  payNo: [
    { required: true, message: '请输入支付流水号', trigger: 'blur' },
  ],
  orderNo: [
    { required: true, message: '请输入订单流水号', trigger: 'blur' },
  ],
  amount: [
    { required: true, message: '请输入交易金额', trigger: 'blur' },
  ]
}

// 新增函数
const addPay = async function () {
  let result = await payServiceAdd(payModel.value);
  Elmessage.success(result.message ? result.message : '添加成功');

  // 新增对话框消失
  dialogFormVisible.value = false;
  // 刷新列表
  getAllPay();
}

// 控制新增或修改变量
const title = ref('')

// 增加或修改展示弹框
const addOrEditPayDialog = function (row) {
  dialogFormVisible.value = true; title.value = '编辑支付信息';
  payModel.payNo = row.payNo;
  payModel.orderNo = row.orderNo;
}

// 删除支付信息函数
const delectPayById = async function (row) {
  ElMessageBox.confirm(
    '确定要删除么?',
    '温馨提示!',
    {
      confirmButtonText: '确认',
      cancelButtonText: '取消',
      type: 'warning',
    }
  ).then(() => {
    // 调用删除接口
    let result = payServiceDelete(row.id);
    ElMessage({
      type: 'success',
      message: '删除成功',
    })
    //刷新列表
    getAllPay();
  }).catch(() => {
    ElMessage({
      type: 'info',
      message: '取消删除',
    })
  })
}

</script>

<style scoped></style>
