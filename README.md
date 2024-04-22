# cloud2024

#### 介绍
JDK17+、Maven3.9.x、SpringCloud23.0.0、SpringCloud Alibaba2021.0.4.0分布式微服务框架

#### 技术版本选型

spring-boot版本: https://github.com/spring-projects/spring-boot/wiki

spring-cloud版本: https://spring.io/projects/spring-cloud#overview

spring-cloud: https://github.com/spring-cloud



spring-cloud-alibaba：https://github.com/alibaba/spring-cloud-alibaba

spring-cloud-alibaba版本说明：https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E

架构图&流程图工具：https://excalidraw.com/

#### 需求说明

> 聚合模块工程依赖配置

约定

1、字符编码 file encoding UTF-8

2、注解生效 勾选 Enable annotation processing

3、编译版本 Java compile 17+

4、文件类型过滤 File Type

配置

hutool 5.8.22
lombok 1.18.26
druid 1.2.20
mybatis-spring-boot 3.0.2
mysql 8.0.11
swagger3 2.2.0
mapper 4.2.3
fastjson2 2.0.40
persistence-api 1.0.2
spring.boot.test 3.1.5
spring-boot-starter 3.2.0
spring.cloud.dependencies 2023.0.0
spring.cloud.alibaba.dependencies 2022.0.0.0-RC2

> 基础工程搭建

mapper4: 生成基础的持久层代码

+ 支付模块 服务提供者 cloud_provider_payment8001

配置

spring-boot-starter-web 3.2.0
spring-boot-starter-actuator 3.2.0
hutool 5.8.22
lombok 1.18.26
druid-spring-boot-starter 1.1.20
mybatis-spring-boot 3.0.2
mysql 8.0.11
persistence-api 1.0.2
mapper 4.2.3
hutool-all 5.8.22
lombok 1.18.26
spring-boot-starter-test 3.1.5
fastjson2 2.0.40
springdoc-openapi-starter-webmvc-ui 2.2.0
mybatis-plus-boot-starter 3.5.3
mybatis-plus-generator 3.5.3
freemarker 2.3.32

统一化

1、时间格式
2、返回结果对象类、枚举结果值
3、全局异常类

+ 订单模块：服务消费者 cloud_consumer_order8002

1、RestTemplate调用服务提供者API使用
2、Get请求完成从服务消费者到服务提供者CRUD

+ 公共模块：抽取对外的暴漏接口、通用组件、共有工具类等 cloud_common_api

1、RestTemplate 服务调用提供者uri硬编码问题，带来维护问题。

> 服务注册与发现

Consul: https://www.consul.io/

什么是Consul: https://developer.hashicorp.com/consul/docs/intro

spring-consul使用: https://docs.spring.io/spring-cloud-consul/reference/quickstart.html

使用spring-consul的issue: https://github.com/spring-cloud/spring-cloud-consul

spring-consul提出的bug：https://stackoverflow.com/questions/tagged/spring-cloud

consul下载安装：https://developer.hashicorp.com/consul/install#windows

consul命令

```json
# 检查
consul --version
```

```json
# 运行
consul agent -dev
```

```json
# 访问        
http://localhost:8500/
```

CAP理论

+ consul分布式动态配置

通用的全局配置注册服务提供者到注册中心consul，从consul中获取服务提供者，遵循consul配置中心。

在consul选择环境配置 --> 浏览器拉取注册中心中的配置

+ consul设置等待时间刷新配置信息

动态刷新配置

#### 演示

1.consul

![consul](https://cloud2024-vue3-ui.oss-cn-shanghai.aliyuncs.com/%E6%9C%8D%E5%8A%A1%E8%B4%9F%E8%BD%BD%E5%9D%87%E8%A1%A1/consul.gif)

> 服务调用与负载均衡

+ ribbon处于维护中，不再更新：https://github.com/Netflix/ribbon

+ LoadBalance客户端负载均衡器

官网是什么：https://docs.spring.io/spring-cloud-commons/reference/4.1-SNAPSHOT/spring-cloud-commons/loadbalancer.html

LoadBalancer的使用：https://docs.spring.io/spring-cloud-commons/reference/4.1-SNAPSHOT/spring-cloud-commons/common-abstractions.html#rest-template-loadbalancer-client

> LoadBalancer两步曲：
> 1、服务消费者从consul server拉取服务列表，如果有多个服务默认轮询方式调用。
> 2、按负载均衡策略转发服务上

+ ctrl + D CloudProviderPaymentApplication8000  

+ consul 服务配置数据持久化

LoadBalancer动态切换客户端：

LoadBalancer 找客户端负载均衡算法：rest接口请求第 xx 次 % 服务器集群总数 = 实际调用服务器位置索引，每次consul重启后rest接口计数从1开始。

LoadBalancer负载均衡算法：https://docs.spring.io/spring-cloud-commons/reference/4.1-SNAPSHOT/spring-cloud-commons/loadbalancer.html

> 轮询：RoundRobinLoadBalancer
> 随机：RandomLoadBalancer

+ openFeign面向接口编程远程调用服务提供者

什么是openFeign官网intro: https://docs.spring.io/spring-cloud-openfeign/docs/4.0.6/reference/html/#spring-cloud-feign

谁是服务消费者/使用的人，谁就用feign公共远程接口~

openFeign源码：https://github.com/spring-cloud/spring-cloud-openfeign

openFeign踩过的坑：https://github.com/spring-cloud/spring-cloud-openfeign/issues

openFeign应用：(面向接口编程)

openFeign的特性：
1. 服务使用者请求服务提供者超时：

https://docs.spring.io/spring-cloud-openfeign/docs/4.0.6/reference/html/#timeout-handling

> 默认超时时间：60s
> 超时控制指定配置：
> https://docs.spring.io/spring-cloud-openfeign/docs/4.0.6/reference/html/#spring-cloud-feign

2. 服务使用者请求重试：

> 超时控制重试指定配置：

https://docs.spring.io/spring-cloud-openfeign/docs/4.0.6/reference/html/#spring-cloud-feign-overriding-defaults

> 重试的次数3 = 1(默认次数) + 2

3. feign使用Apache HTTPClient5请求


4. feign请求响应压缩

https://docs.spring.io/spring-cloud-openfeign/docs/4.0.6/reference/html/#feign-requestresponse-compression

5. feign日志级别输出

https://docs.spring.io/spring-cloud-openfeign/docs/4.0.6/reference/html/#feign-logging

问题：在日常应用app中应该如何选择LoadBalancer和openFeign呢？

#### 演示

2.loadbalancer

![loadbalancer](https://cloud2024-vue3-ui.oss-cn-shanghai.aliyuncs.com/%E6%9C%8D%E5%8A%A1%E8%B4%9F%E8%BD%BD%E5%9D%87%E8%A1%A1/loadbalancer1.gif)

> 服务熔断和降级

Hystrix Status: https://github.com/Netflix/Hystrix/blob/master/README.md

+  断路器：用于处理生产故障

断路器Circuit Breaker的实现Resilience4J官网：https://spring.io/projects/spring-cloud-circuitbreaker#overview

resilience4j源码：https://github.com/resilience4j/resilience4j

resilience4j是什么：https://github.com/resilience4j/resilience4j?tab=readme-ov-file#introduction

resilience4j-Circuitbreaker配置API和参数：https://resilience4j.readme.io/docs/circuitbreaker

> 常见的断路器在应用中的问题：
> 1、项目的稳定性方案有哪些？如何解决和优化？


resilience4j-ratelimiter参数配置：https://resilience4j.readme.io/docs/ratelimiter

常见的限流算法：

> 漏桶算法(Leaky bucket)
> 令牌桶算法(Token bucket)
> 滚动时间窗(tumbling time window)
> 滑动时间窗口（sliding time window）

resilience4j-bulkhead配置参数：https://resilience4j.readme.io/docs/bulkhead

SemaphoreBulkhead信号量舱壁：当信号量空闲时，进入系统请求直接获取信号量执行业务处理；当信号量被占用时，请求进图阻塞状态，系统就会拒绝这些请求。

FixedThreadPoolBulkhead固定线程池舱壁：用户限制并发执行次数，当线程池存在空闲时，进入系统的请求直接进入线程池开启线程或使用空闲线程处理请求。
线程池无空闲时，接下来请求进入等待队列，队列满了，请求就直接被拒绝。

> 分布式链路追踪

Spring Cloud Sleuth官网：https://github.com/spring-cloud/spring-cloud-sleuth 维护中

Micrometer使用说明: https://docs.micrometer.io/micrometer/reference/overview.html

Zipkin安装：https://zipkin.io/pages/quickstart.html

> 网关

gateway官网：https://docs.spring.io/spring-cloud-gateway/reference/index.html

gateway的特性文档：https://docs.spring.io/spring-cloud-gateway/reference/spring-cloud-gateway/glossary.html

gateway网关的路由映射: https://docs.spring.io/spring-cloud-gateway/reference/spring-cloud-gateway/configuration.html







#### 报错说明

1. 错误现象：Class com.sun.tools.javac.tree.JCTree$JCImport does not have member field 'com.sun.tools.javac.tree.JCTree qualid'

原因：Spring Boot3.2.0版本与你的JDK17版本需要一一对应兼容，同时maven编译配置版本17一一对应，运行时的版本jdk17一一对应，在service --> edit configuration --> build and run（中一一对应jdk17）

2.错误现象：springboot3.2.0、mybatisplus3.5.3代码生成器后的代码结构启动报错Invalid value type for attribute 'factoryBeanObjectType': java.lang.String

原因：springboot3.2.0适配mybatisplus版本依赖坐标

```xml
<!-- mybatis-plus-boot-starter -->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.4</version>
</dependency>

<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.5.4</version>
</dependency>

<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>3.0.3</version>
</dependency>

<!-- freemarker -->
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
    <version>2.3.32</version>
</dependency>
```


#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
