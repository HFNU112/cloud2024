package com.atguigu.cloud;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

/**
 * @Author Husp
 * @Date 2024/3/7 23:47
 */
@SpringBootTest
public class CloudProviderPaymentTest {

    @Test
    void testGenerator() {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/cloud2024?charactEncoding=UTF-8&serverTimezone=UTC", "root", "root")
                //1.全局配置
                .globalConfig(builder -> {
                    builder.author("shunpeng.hu")
//                            .enableSwagger()
                            .fileOverride()  // 是否覆盖
                            .outputDir("E:\\springcloud_work\\cloud2024\\cloud_provider_payment8001\\src\\main\\java") // 设置生成路径
                            .dateType(DateType.ONLY_DATE);
                })
                //2.包的配置
                .packageConfig(builder -> {
                    builder.moduleName("generator")
                            .parent("com.at.cloud")
                            .entity("entities")
                            .mapper("mapper")
                            .service("service")
                            .serviceImpl("impl")
                            .controller("controller")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "E:\\springcloud_work\\cloud2024\\cloud_provider_payment8001\\src\\main\\resources\\mapper"));
                })
                //3.策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("tb_pay") // 设置要映射的表
                            .addTablePrefix("tb_")  // 设置过滤表前缀
                            .entityBuilder().enableLombok() // 自动lombok
                            .naming(NamingStrategy.underline_to_camel)
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .logicDeletePropertyName("deleted");  // 逻辑删除
                })
                //4.Freemarker引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
