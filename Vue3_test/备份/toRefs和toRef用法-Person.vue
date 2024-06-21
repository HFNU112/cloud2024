<template>
    <div class="person">
        <h2> 姓名：{{ person.name }}</h2>            
        <h2> 年龄{{ person.age }}</h2>            
        <h2> 性别：{{ person.gender }}</h2>            
        <h2> 地址：{{ person.addr }}</h2>
        
        <button @click="changeName"> 修改姓名 </button>
        <button @click="changeAge"> 修改年龄 </button>
        <button @click="changeGender"> 修改性别 </button>
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
    import {ref, reactive, toRefs, toRef} from 'vue'

    // 定义变量
    let person = reactive({name:'xiaobu', age:18, gender:'男', addr:'上海徐汇'})
    
    //通过toRefs将person对象中的n个属性批量取出，且依然保持响应式的能力
    let {name, age, gender} = toRefs(person)
  
    console.log(toRefs(person))

    // toRef将person对象中的gender属性取出，且依然保持响应式的能力
    let ref_age =toRef(person, 'age')
    console.log(ref_age.value)
    

    // 定义函数
    function changeName() {
        name.value = '小布';
        console.log(name.value, person.name)
    }

    function changeAge() {
        age.value += 1;
        console.log(age.value, person.age)
    }

    function changeGender() {
        gender.value = '女';
        console.log(gender.value, person.gender)
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