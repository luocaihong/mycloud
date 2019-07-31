package com.sg.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaApp
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-04-29 14:36
 * @Since 1.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigApp.class);
    }
}
