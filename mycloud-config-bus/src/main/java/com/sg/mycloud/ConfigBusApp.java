package com.sg.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ConfigBusApp
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-05-16 16:16
 * @Since 1.0
 **/
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigBusApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigBusApp.class, args);
    }
}
