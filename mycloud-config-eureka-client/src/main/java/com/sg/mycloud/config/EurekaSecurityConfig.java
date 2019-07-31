package com.sg.mycloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName EurekaSecurityConfig
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-04-29 15:58
 * @Since 1.0
 **/
@Configuration
@EnableWebSecurity
public class EurekaSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // 重写configure方法，把csrf劫持关闭
        super.configure(http);
    }
}
