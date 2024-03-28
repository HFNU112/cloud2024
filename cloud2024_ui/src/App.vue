<!--<script>-->
<!--  export default {-->
<!--    data(){-->
<!--      return{-->
<!--        message: "上海"-->
<!--      }-->
<!--    }-->
<!--  }-->
<!--</script>-->

<script setup>
import {ref} from 'vue';
// 调用ref函数，定义响应式函数
const message = ref('南京')

// 导入Api.vue文件
// import ApiVue from './Api.vue';

// 导入pay.vue文件
// import PayVue from '../备份/pay.vue';

import PayVue from './pay.vue';

// 导入sso.vue文件
// import sso from './sso.vue';

// import PayVue from './vue/pay.vue';
</script>

<template>
  <header>
<!--    <div>-->
<!--      <img alt="Vue logo" class="logo" src="./assets/logo.svg" width="125" height="125"/>-->
<!--    </div>-->
    <div class="wrapper">
      <HelloWorld msg="You did it!"/>
      <!--      <br>-->
      <!--      <h1>欢迎页</h1>-->
      <!--      <br>-->
      <!--      <h1> {{ message }}</h1>-->
    </div>
    <br>
    <!--  声明文件  -->
       <!-- <ApiVue/> -->

    <PayVue/>

    <!-- <sso.vue/> -->

  </header>

  <main>
    <TheWelcome/>
  </main>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}

h1 {
  color: #ff0000;
}
</style>
