package com.sg.mycloud.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @ClassName InfoConfig
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-05-16 16:39
 * @Since 1.0
 **/
@Component
@RefreshScope
@Getter
@Setter
@ToString
public class InfoConfig {
    @Value("${info.app.name}")
    private String appName;

    @Value("${info.company.name}")
    private String companyName;
}
