<template>
  <div class="mb-4">
    <el-button type="success"> 新增</el-button>
    <el-button type="danger"> 删除</el-button>
  </div>
  <br>

  <el-form :inline="true" :model="formInline" class="demo-form-inline">
    <el-form-item label="支付流水号">
      <el-select
          v-model="formInline.region"
          placeholder="请选择支付流水号"
          clearable>
        <el-option label="Zone one" value="shanghai"/>
        <el-option label="Zone two" value="beijing"/>
      </el-select>
    </el-form-item>
    <el-form-item label="创建日期">
      <el-date-picker
          v-model="formInline.date"
          type="date"
          placeholder="请选择日期"
          clearable
      />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit"> 搜索</el-button>
    </el-form-item>
  </el-form>

  <div id="app">
  <!-- 列表数据 -->
  <el-table :data="payLists" style="width: 100%">
    <el-table-column fixed prop="createTime" label="创建日期" width="150"/>
    <el-table-column prop="payNo" label="支付流水号" width="120"/>
    <el-table-column prop="orderNo" label="订单流水号" width="120"/>
    <el-table-column prop="userId" label="用户id" width="120"/>
    <el-table-column prop="amount" label="交易金额" width="300"/>
    <el-table-column fixed="right" label="操作" width="120">
      <template #default>
        <div>
          <el-button link type="primary" size="small" @click="handleClick"
          > 详情
          </el-button
          >
          <el-button link type="primary" size="small"> 编辑</el-button>
        </div>
      </template>
    </el-table-column>
  </el-table>
  </div>

  <!-- 分页组件 -->
  <el-pagination class="demo-pagination-block"
                 v-model:current-page="currentPage4"
                 v-model:page-size="pageSize4"
                 :page-sizes="[10, 20, 50, 100, 200]"
                 :small="small"
                 :disabled="disabled"
                 :background="background"
                 layout="total, sizes, prev, pager, next, jumper"
                 :total="400"
                 @size-change="handleSizeChange"
                 @current-change="handleCurrentChange"
  />
</template>

<script lang="ts" setup>
import {ref} from 'vue';
// 导入api接口的js文件
// import {payServiceSelectAll, payServiceSelectCondition} from '@/api/pay.js';
import Vue from 'vue';
import axios from 'axios';

export default Vue.extend({
  data() {
    return {
      formInline: {
        user: '',
        region: '',
        date: '',
      },
      payLists: [],
    }
  },
});

// const formInline = reactive({
//   user: '',
//   region: '',
//   date: '',
// })

// const onSubmit = () => {
//   console.log('submit!')
// }


// const currentPage1 = ref(5)
// const currentPage2 = ref(5)
// const currentPage3 = ref(5)
// const currentPage4 = ref(4)
// const pageSize2 = ref(100)
// const pageSize3 = ref(100)
// const pageSize4 = ref(100)
// const small = ref(false)
// const background = ref(false)
// const disabled = ref(false)

// const handleSizeChange = (val: number) => {
//   console.log(`${val} items per page`)
// }
// const handleCurrentChange = (val: number) => {
//   console.log(`current page: ${val}`)
// }

// const handleClick = () => {
//   console.log('click')
// }

// //定义响应式数据
// const payLists = ([
//   {
//     createTime: '2016-05-03',
//     payNo: 'Tom',
//     orderNo: 'California',
//     userId: 'Los Angeles',
//     amount: 'No. 189, Grove St, Los Angeles',
//   },
//   {
//     createTime: '2016-05-03',
//     payNo: 'Tom',
//     orderNo: 'California',
//     userId: 'Los Angeles',
//     amount: 'No. 189, Grove St, Los Angeles',
//   }
// ])







</script>

<style scoped>
.demo-pagination-block {
  margin-top: 20px;
  display: flex;
  justify-content: flex-end;
}

.demo-pagination-block {
  margin-bottom: 60px;
  display: flex;
  justify-content: flex-end;
}
</style>
