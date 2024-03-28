# cloud2024_ui

This template should help get you started developing with Vue 3 in Vite.

## Project Demonstration

1. 新增支付


2. 删除支付


3. 修改支付


4. 查询支付


## Recommended IDE Setup

[VSCode](https://code.visualstudio.com/) + [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) (and disable Vetur) + [TypeScript Vue Plugin (Volar)](https://marketplace.visualstudio.com/items?itemName=Vue.vscode-typescript-vue-plugin).

## Type Support for `.vue` Imports in TS

TypeScript cannot handle type information for `.vue` imports by default, so we replace the `tsc` CLI with `vue-tsc` for type checking. In editors, we need [TypeScript Vue Plugin (Volar)](https://marketplace.visualstudio.com/items?itemName=Vue.vscode-typescript-vue-plugin) to make the TypeScript language service aware of `.vue` types.

If the standalone TypeScript plugin doesn't feel fast enough to you, Volar has also implemented a [Take Over Mode](https://github.com/johnsoncodehk/volar/discussions/471#discussioncomment-1361669) that is more performant. You can enable it by the following steps:

1. Disable the built-in TypeScript Extension
    1) Run `Extensions: Show Built-in Extensions` from VSCode's command palette
    2) Find `TypeScript and JavaScript Language Features`, right click and select `Disable (Workspace)`
2. Reload the VSCode window by running `Developer: Reload Window` from the command palette.

## Customize configuration

See [Vite Configuration Reference] https://vitejs.dev/config/)

## 前端工程资料

![vuejs] https://vuejs.org/guide/quick-start.html

![axios-http] https://www.axios-http.cn/docs/example

![vite] https://cn.vitejs.dev/

## Project Setup

```json
npm create vue@latest
```

### Compile and Hot-Reload for Development

```sh
npm run dev
```

### Type-Check, Compile and Minify for Production

```sh
npm run build
```

### 异步请求axios

````json
npm install axios
````

### 前后端接口联调跨域(CORS)

> 由于一个浏览器（客户端）的同源策略的限制，向不同源【不同协议、不同域名(IP)、不同端口(PORT)】发送异步请求失败。

### element-plus组件

![element-plus] https://element-plus.org/zh-CN/component/overview.html

1、下载element-plus依赖

```json
npm install element-plus --save
```

2、引入element-plus依赖

```json
// main.ts
import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'

const app = createApp(App)

app.use(ElementPlus)
app.mount('#app')
```
### vue3路由规则
