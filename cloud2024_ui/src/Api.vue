<template>
  <button @click="increment"> count: {{ count }}</button>
</template>

<!--组合式api-->
<script setup>
// 1.导入依赖
import {ref, onMounted} from 'vue';
// 2. 声明响应式数据ref, 响应式对象的属性值value
const count = ref(0)

// 声明点击事件的函数
function increment(){
  count.value++;
}

// 声明钩子函数
onMounted(() => {
  console.log("vue 加载完毕了~")
});

</script>

<style scoped>

</style>
