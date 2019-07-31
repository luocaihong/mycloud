package com.sg.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName UserApp
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-04-28 11:11
 * @Since 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker // hystrix熔断支持
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class);
    }
}
