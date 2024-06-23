<template>
  <div class="person">
    名：<input type="text" v-model="lastName"><br>
    姓：<input type="text" v-model="firstName"><br>
    <!--  这种写法在维护上不简化表达式的值  -->
    <!--    全名：<span> {{firstName}} {{lastName}} </span><br>-->
    全名：<span> {{ fullName }} </span><br>

    <button @click="changeFullName"> 修改全名 </button>
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
// 计算属性数据——既读取又修改
import {ref, reactive, computed} from 'vue'

// 根据已有数据计算出新数据 computed用法
let lastName = ref('shunpeng');
let firstName = ref('hu');

// computed计算属性, 只读属性不能写操作
// let fullName = computed(() => {
//   return firstName.value.slice(0, 1).toUpperCase() + firstName.value.slice(1) +
//       lastName.value.slice(0, 1).toUpperCase() + lastName.value.slice(1);
// })

// computed计算属性，——既读取又修改
let fullName = computed({
  get: () => {
    return firstName.value + '-' + lastName.value;
  },
  set: (value) => {
    console.log('修改fullName：', value)
    let names = value.split('-');
    firstName.value = names[1];
    lastName.value = names[0];
  }
})

//定义函数
function changeFullName() {
  console.log('要修改的fullName:', fullName.value)
  // fullName.value = 'shunpeng-hu';
  fullName.value = 'hao-xu';
}

</script>

<style>
.person {
  background-color: #5c88ed;
  box-shadow: 0 0 10px;
  border-radius: 10px;
  padding: 20px;
}
</style>