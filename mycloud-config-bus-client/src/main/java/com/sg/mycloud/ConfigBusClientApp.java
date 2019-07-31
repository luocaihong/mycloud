package com.sg.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ConfigApp
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-05-14 21:16
 * @Since 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
public class ConfigBusClientApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigBusClientApp.class, args);
    }
}
