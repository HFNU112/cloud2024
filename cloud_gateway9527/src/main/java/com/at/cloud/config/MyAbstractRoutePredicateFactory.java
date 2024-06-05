package com.at.cloud.config;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * 1.自定义路由断言规则工厂继承AbstractRoutePredicateFactory类，自动实现RoutePredicateFactory接口
 * @author shunpeng.hu
 * @date 2024/6/5 14:09
 */
@Component
public class MyAbstractRoutePredicateFactory extends AbstractRoutePredicateFactory<MyAbstractRoutePredicateFactory.Config> {

    /**
     * 4. 无参构造方法
     */
    public MyAbstractRoutePredicateFactory() {
        super(Config.class);
    }

    /**
     * 2.重写apply方法
     * @param config MyAbstractRoutePredicateFactory
     * @return Predicate
     */
    @Override
    public Predicate<ServerWebExchange> apply(MyAbstractRoutePredicateFactory.Config config) {
        return new Predicate<ServerWebExchange>(){

            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                //检查request的参数里面，userType是否为指定的值，符合配置就通过
                String userType = serverWebExchange.getRequest().getQueryParams().getFirst("userType");
                if (userType == null) {
                    return false;
                }
                //如果说参数存在，就和config的数据进行比较
                if(userType.equals(config.getUserType())) {
                    return true;
                }
                return false;
            }

        };
    }

    /**
     * 短格式规则
     * @return List
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("userType");
    }

    /**
     * 3.新建一个静态内部类Config，就是自己路由断言规则
     */
    @Validated
    public static class Config {

        @Setter
        @Getter
        @NotEmpty
        private String userType; // 用户类型 user/vip/svip
    }
}
