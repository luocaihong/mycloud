package com.sg.ribbon;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName RibbonConfig
 * @Description 新增一个路由规则的配置类，注意这个类不应该放到SpringCloud扫描到的位置，否则又回变成全局的IRULE，所以这个时候应该单独使用一个新的包，着个包和启动并不在同一个包下
 * @Author luocaihong
 * @Date 2019-05-06 09:23
 * @Since 1.0
 **/
public class RibbonConfig {
    @Bean
    public IRule ribbonRule() { // 其中IRule就是所有规则的标准
        return new com.netflix.loadbalancer.RandomRule(); // 随机的访问策略,默认是轮询
    }
}
