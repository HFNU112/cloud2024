<template>
    <el-container class="layout-container-demo" style="height: 500px">
        <el-aside width="200px">
            <el-scrollbar>
                <el-menu :default-openeds="['1', '3']">
                    <el-sub-menu index="1">
                        <template #title>
                            <el-icon>
                                <message />
                            </el-icon> 支付服务
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="1-1">支付列表</el-menu-item>
                        </el-menu-item-group>
                    </el-sub-menu>
                    <el-sub-menu index="2">
                        <template #title>
                            <el-icon><icon-menu /></el-icon> 订单服务
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="2-1">订单列表</el-menu-item>
                        </el-menu-item-group>
                    </el-sub-menu>
                </el-menu>
            </el-scrollbar>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <div class="toolbar">
                    <el-dropdown>
                        <el-icon style="margin-right: 15px; margin-top: 2px">
                            <setting />
                        </el-icon>
                        <template #dropdown>
                            <el-dropdown-menu>
                                <el-dropdown-item>个人中心</el-dropdown-item>
                                <el-dropdown-item>修改密码</el-dropdown-item>
                            </el-dropdown-menu>
                        </template>
                    </el-dropdown>
                    <span>Tom</span>
                </div>
            </el-header>

            <el-main>
                <el-scrollbar>
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
                </el-scrollbar>
            </el-main>
        </el-container>
    </el-container>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { Menu as IconMenu, Message, Setting } from '@element-plus/icons-vue'
// 导入api接口的js文件
import {payServiceSelectAll, payServiceSelectCondition, payServiceAdd, payServiceDelete} from '@/api/pay.js';

const item = {
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
}

const payList = ref([
    {
        "createTime":"",
        "payNo":"",
        "orderNo":"",
        "userId":"",
        "amount":"",
    }
])

// 获取数据
// 调用同步获取数据的函数网络请求 await async
const getAllPay = async function () {
  payList.value = await payServiceSelectAll();
}

// 调用函数
getAllPay();

</script>

<style scoped>
.layout-container-demo .el-header {
    position: relative;
    background-color: var(--el-color-primary-light-7);
    color: var(--el-text-color-primary);
}

.layout-container-demo .el-aside {
    color: var(--el-text-color-primary);
    background: var(--el-color-primary-light-8);
}

.layout-container-demo .el-menu {
    border-right: none;
}

.layout-container-demo .el-main {
    padding: 0;
}

.layout-container-demo .toolbar {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    height: 100%;
    right: 20px;
}</style>