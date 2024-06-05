<template>
    <div class="person">
        <h1> 姓名：{{ name }}</h1>
        <h1> 年龄：{{ age }} </h1>

        <button @click="showTel"> 点击查询电话 </button>
        <button @click="updateName"> 修改姓名 </button>
        <button @click="updateAge"> 修改年龄 </button>
    </div>
</template>
<script lang="ts">

    export default {
        name:"Person",
        data() {
            return {
                name: "husp",
                age: 26,
                tel: "15288888888"
            }
        },
        methods: {
            updateName(){
                this.name = "shunpeng_hu"
            },
            updateAge(){
                this.age += 1
            },
            showTel() {
                console.log(this.tel);
            }  
        },
    }
</script scoped>
<style>
    .person{
        background-color: #5c88ed;
        box-shadow: 0 0 10px;
        border-radius: 10px;
        padding: 20px;
    }
</style>