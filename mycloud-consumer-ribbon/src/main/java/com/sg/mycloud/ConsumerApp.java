package com.sg.mycloud;

import com.sg.ribbon.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName ConsumerApp
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-04-28 13:42
 * @Since 1.0
 **/
@SpringBootApplication
@RibbonClient(name = "MYCLOUD-PROVIDER-PRODUCT", configuration = RibbonConfig.class) // 指定某个服务使用特定的ribbon配置
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class);
    }
}
