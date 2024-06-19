<template>
    <div class="person">
        <h1> 姓名：{{ name }}</h1>
        <h1> 年龄：{{ age }} </h1>

        <h2> 汽车信息：一台{{ car.brand }}汽车，价值{{ car.price }}万元</h2>
        <hr>
        <h2> 游戏列表: </h2>
        <ul>
            <li v-for="g in games" :key="g.id">{{ g.name }}</li>
        </ul>
        <h2> 测试：{{ obj.a.b.c.d }}</h2>
        <hr>
        <h2> 当前和为：{{ sum }}</h2>
        <button @click="changeSum"> 累计求和 </button>

        <button @click="showTel"> 点击查询电话 </button>
        <button @click="updateName"> 修改姓名 </button>
        <button @click="updateAge"> 修改年龄 </button>
        <button @click="changeCarPrice"> 修改汽车价格 </button>
        <button @click="changeCarBrand"> 修改汽车品牌 </button>
        <button @click="changeCar"> 修改汽车 </button>
        <button @click="changeFirstGame"> 修改第一游戏名称 </button>
        <button @click="test"> 点击测试 </button>    
    </div>
</template>
<!-- <script lang="ts">
    // 
    export default {
        name:"Person",
    }
</script scoped> -->
 
<script lang="ts" setup name="Person">
    // 引入ref可以定义响应式基本类型变量数据，也可以定义对象类型数据。引入reactive定义响应式对象类型的数据。
    import {ref, reactive} from 'vue'

    // 定义变量
    let name = ref('大鹏');
    let age = ref(26);
    let tel = '15288888888';
    // reactive定义对象变量
    // let car = reactive({
    //     brand: '奥迪A8L',
    //     price: 100
    // })

    // let car = ref({brand: '奥迪A8L', price: 100})
    let car = reactive({brand: '奥迪A8L', price: 90})

    let sum = ref(0);

    // reactive定义数组变量
    // let games = reactive([
    //     {id: "abceedijf", name: '穿越火线'},
    //     {id: "abceedijen", name: '王者荣耀'},
    //     {id: "abceediji", name: '元神'},
    //     {id: "abceedise", name: '铁道苍穹'}
    // ])

    let games = ref([
        {id: "abceedijf", name: '穿越火线'},
        {id: "abceedijen", name: '王者荣耀'},
        {id: "abceediji", name: '元神'},
        {id: "abceedise", name: '铁道苍穹'}
    ])

    let obj  = ref({
        a: {
            b: {
                c: {
                    d: 33666
                }
            }
        }
    })

    // 定义函数
    function updateName(){
        name.value = 'shunpeng_hu';
        console.log(name.value);
    }
    function updateAge(){
        age.value += 1;
        console.log(age.value);
    }
    function showTel() {
        console.log(tel);
    }
    function changeCarPrice(){
        car.price += 10;
        console.log(car.price);
    }
    function changeCarBrand(){
        car.brand = '保时捷911';
        console.log(car.brand);
    }
    //reactive重新分配一个新对象，会失去响应式。
    function changeCar(){
        // car = {brand: '宝马', price: 100}
        // car = reactive({brand: '宝马', price: 100})
        Object.assign(car, {brand: '宝马', price: 100})
    }
    function changeFirstGame(){
        games.value[0].name = '流星蝴蝶剑';
        console.log(games.value[0].name);
    }
    function test(){
        obj.value.a.b.c.d = 33999;
        console.log(obj.value.a.b.c.d);
    }

    function changeSum(){
        sum.value += 1;
        console.log(sum.value);
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