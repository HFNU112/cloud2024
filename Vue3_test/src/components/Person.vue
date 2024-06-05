<template>
    <div class="person">
        <h1> 姓名：{{ name }}</h1>
        <h1> 年龄：{{ age }} </h1>

        <button @click="showTel"> 点击查询电话 </button>
        <button @click="updateName"> 修改姓名 </button>
        <button @click="updateAge"> 修改年龄 </button>
    </div>
</template>
<!-- <script lang="ts">
    // 
    export default {
        name:"Person",
    }
</script scoped> -->

<script lang="ts" setup name="Person">
    // 定义变量
    let name = '大鹏';
    let age = 26;
    let tel = '15288888888';

    // 定义函数
    function updateName(){
        name = 'shunpeng_hu';
        console.log(name);
    }
    function updateAge(){
        age += 1;
        console.log(age);
    }
    function showTel() {
        console.log(tel);
    }

</script>

<style>
    .person{
        background-color: #5c88ed;
        box-shadow: 0 0 10px;
        border-radius: 10px;
        padding: 20px;
    }
</style>