# cloud2024

#### 介绍
JDK17+、Maven3.9.x、SpringCloud23.0.0、SpringCloud Alibaba2021.0.4.0分布式微服务框架

#### 技术版本选型

spring-boot版本: https://github.com/spring-projects/spring-boot/wiki

spring-cloud版本: https://spring.io/projects/spring-cloud#overview

spring-cloud: https://github.com/spring-cloud



spring-cloud-alibaba：https://github.com/alibaba/spring-cloud-alibaba

spring-cloud-alibaba版本说明：https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E


#### 需求说明

聚合模块工程

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

基础工程搭建

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

- 公共模块：抽取对外的暴漏接口、通用组件、共有工具类等 cloud_common_api

1、RestTemplate 服务调用提供者uri硬编码问题，带来维护问题。



#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

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
