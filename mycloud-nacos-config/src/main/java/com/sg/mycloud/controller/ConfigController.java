package com.sg.mycloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigController
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-08-05 17:29
 * @Since 1.0
 **/
@RestController
@RequestMapping("/config")
@RefreshScope //实现配置自动更新
public class ConfigController {
    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Value("${current.env}")
    private String currentEnv;

    @RequestMapping("/get")
    public String get() {
        return String.format("useLocalCache=%s;currentEnv=%s", String.valueOf(useLocalCache), currentEnv);
    }
}
