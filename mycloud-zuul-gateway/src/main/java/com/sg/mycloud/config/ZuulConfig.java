package com.sg.mycloud.config;

import com.sg.mycloud.filter.AuthorizedRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ZuulConfig
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-05-12 17:50
 * @Since 1.0
 **/
@Configuration
public class ZuulConfig {
    @Bean
    public AuthorizedRequestFilter getAuthorizedRequestFilter() {
        return new AuthorizedRequestFilter() ;
    }
}
