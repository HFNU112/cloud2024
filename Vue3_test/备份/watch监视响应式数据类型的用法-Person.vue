<template>
  <div class="person">
    <h1> 情形一：watch监视【ref】定义的【基本类型】数据</h1>
    <h2> 当前求和：{{ sum }} </h2>
    <button @click="changeSum"> 点击累计求和</button>

    <h1> 情形二：watch监视【ref】定义的【对象类型】数据</h1>
    <h2> 姓名：{{ person.name }}</h2>
    <h2> 年龄：{{ person.age }}</h2>
    <h2> 地址：{{ person.addr }}</h2>
    <button @click="changeName"> 修改姓名</button>
    <button @click="changeAge"> 修改年龄</button>
    <button @click="changePerson"> 修改整个对象</button>

    <h1> 情形三：watch监视【reactive】定义的【对象类型】数据</h1>
    <h2> 姓名：{{ person2.name }}</h2>
    <h2> 年龄：{{ person2.age }}</h2>
    <h2> 地址：{{ person2.addr }}</h2>
    <hr>
    <h2> 测试：{{ obj.a.b.c.d }}</h2>
    <button @click="changeName2"> 修改姓名</button>
    <button @click="changeAge2"> 修改年龄</button>
    <button @click="changePerson2"> 修改整个对象</button>
    <button @click="changeObj"> 修改test </button>

    <h1> 情形四：监视【ref】或【reactive】定义的【对象类型】数据中的某个属性</h1>
    <h2> 姓名：{{ person3.name }}</h2>
    <h2> 年龄：{{ person3.age }}</h2>
    <h2> 性别：{{ person3.gender }}</h2>
    <h2> 拥有的汽车：{{ person3.car.car1 }} {{ person3.car.car2 }}</h2>
    <button @click="changeName3"> 修改姓名 </button>
    <button @click="changeAge3"> 修改年龄 </button>
    <button @click="changeCar1"> 修改第一台汽车 </button>
    <button @click="changeCar2"> 修改第二台汽车 </button>
    <button @click="changeCar"> 修改整车 </button>
    <h1> 情形五：watch监视【ref】或【reactive】定义的【数据类型】包括多个数据</h1>
    <h2> 姓名：{{ person4.name }}</h2>
    <h2> 年龄：{{ person4.age }}</h2>
    <h2> 性别：{{ person4.gender }}</h2>
    <h2> 拥有的汽车：{{ person4.car.car1 }} {{ person4.car.car2 }}</h2>
    <button @click="changeName4"> 修改姓名 </button>
    <button @click="changeAge4"> 修改年龄 </button>
    <button @click="changeCar4_1"> 修改第一台汽车 </button>
    <button @click="changeCar4_2"> 修改第二台汽车 </button>
    <button @click="changeCar_2"> 修改整车 </button>
    <button @click="changePerson4"> 修改整个对象 </button>

  </div>
</template>
<!-- <script lang="ts">
    // 
    export default {
        name:"Person",
    }
</script scoped> -->

<script lang="ts" setup name="Person">
// watch监视ref、reactive、getter函数返回值、包含前三个内容的数组数据的变化
import {ref, reactive, watch} from 'vue'
//定义数据
let sum = ref(0)

// 定义对象数据
let person = ref({name: '大鹏', age: 20, addr: '上海徐汇'})

let person2 = reactive({name: '大鹏', age: 20, addr: '上海徐汇', gender: '男'})

let person3 = reactive({
  name: '大鹏',
  age: 20,
  gender: '男',
  car: {
    car1: '蔚来',
    car2: '特斯拉'
  }
})

let person4 = reactive({
  name: '大鹏',
  age: 20,
  gender: '男',
  addr: '上海徐汇',
  car: {
    car1: '蔚来',
    car2: '特斯拉'
  }
})

let obj = reactive({
  a: {
    b: {
      c:{
        d: 33666
      }
    }
  }
})

//定义函数
function changeSum() {
  sum.value += 1
}

//watch监视
const stopwatch = watch(sum, (newValue, oldValue) => {
  console.log('sum变化了：', '更新后：' + newValue, '更新前：' + oldValue)
  if (newValue >= 10) {
    stopwatch();
  }
})

// 定义对象方法
function changeName() {
  person.value.name = '晓彤'
}

function changeName2() {
  person2.name = '晓彤'
}

function changeName3() {
  person3.name = '晓彤'
}

function changeName4(){
  person4.name = '晓彤'
}

function changeAge() {
  person.value.age += 1
}

function changeAge2() {
  person2.age += 1
}

function changeAge3() {
  person3.age += 1
}

function changeAge4(){
  person4.age += 1
}

function changePerson() {
  person.value = {name: '晓彤', age: 18, addr: '北京'}
}

function changePerson2() {
  Object.assign(person2, {name: '晓彤', age: 18, addr: '北京', gender: '女'})
}

function changeCar1(){
  person3.car.car1 = '保时捷'
}

function changeCar2(){
  person3.car.car2 = '兰博基尼'
}

function changeCar4_1(){
  person4.car.car1 = '保时捷'
}

function changeCar4_2(){
  person4.car.car2 = '兰博基尼'
}

function changeCar() {
  person3.car = {
    car1: '保时捷',
    car2: '兰博基尼'
  }
}

function changePerson4(){
  Object.assign(person4, {name: '晓彤', age: 18, addr: '北京', gender: '女', car: {car1: '保时捷', car2: '兰博基尼'}})
}

function changeCar_2(){
  Object.assign(person4.car, {car1: '保时捷', car2: '兰博基尼'})
}

function changeObj() {
  obj.a.b.c.d = 33777
}

// 监视对象数据，监视【ref】定义的【对象类型】数据，监视的是对象的地址值，若想监视对象内部属性的变化，需要手动开启深度监视,配置对象属性（deep、immediate等等.....）
watch(person, (newValue, oldValue) => {
  console.log('person变化了：', newValue, oldValue)
}, {deep: true})

// 监视对象数据，监视【reactive】定义的【对象类型】数据，监视的是对象的地址值，若想监视对象内部属性的变化，需要手动开启深度监视,配置对象属性（deep、immediate等等.....）
watch(person2, (newValue, oldValue) => {
  console.log('person2变化了：', newValue, oldValue)
}, {deep: true})

watch(obj, (newValue, oldValue) => {
  console.log('obj变化了：', newValue, oldValue)
})

// 监视对象的某个属性，监视响应式对象中的某个属性，且该属性是基本类型的，要写成函数式
watch(() => person3.name, (newValue, oldValue) => {
  console.log('person3.name变化了：', newValue, oldValue)
})

watch(() => person3.age, (newValue, oldValue) => {
  console.log('person3.age变化了：', newValue, oldValue)
})

//监视响应式对象中的某个属性，且该属性是对象类型的，可以直接写，也能写函数
watch(() => person3.car, (newValue, oldValue) => {
  console.log('person3.car变化了：', newValue, oldValue)
})

//监视，情况五：监视上述的多个数据
watch([() => person4.name, () => person4.age, () => person4.addr, () => person4.car.car1, () => person4.car.car2], (newValue, oldValue) => {
  console.log('person4变化了：', newValue, oldValue)
}, {deep: true})

</script>

<style>
.person {
  background-color: #5c88ed;
  box-shadow: 0 0 10px;
  border-radius: 10px;
  padding: 20px;
}
</style>