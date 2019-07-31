package com.sg.mycloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ProductApp
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-04-28 11:11
 * @Since 1.0
 **/
@SpringBootApplication
@MapperScan("com.sg.mycloud.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker // hystrix熔断支持
public class ProductApp {
    public static void main(String[] args) {
        SpringApplication.run(ProductApp.class);
    }
}
