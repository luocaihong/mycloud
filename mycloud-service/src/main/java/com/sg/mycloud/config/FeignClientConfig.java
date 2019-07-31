package com.sg.mycloud.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignClientConfig
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-05-08 09:19
 * @Since 1.0
 **/
@Configuration
public class FeignClientConfig {
    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
        // 这里指定的是provider的密码
        return new BasicAuthRequestInterceptor("admin", "12345678");
    }

    // 只添加配置还无法实现对DEBUG日志的输出，以因为Feign客户端默认的logger.level对象定义为none级别，所以不会记录feign调用过程中的信息
    @Bean
    public Logger.Level getFeignLoggerLevel() {
        return feign.Logger.Level.FULL ;
    }
}
