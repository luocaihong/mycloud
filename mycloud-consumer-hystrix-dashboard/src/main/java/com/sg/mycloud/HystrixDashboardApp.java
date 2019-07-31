package com.sg.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ClassName ConsumerApp
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-04-28 13:42
 * @Since 1.0
 **/
@SpringBootApplication
@EnableHystrixDashboard // 启用dashboard服务监测
public class HystrixDashboardApp {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApp.class);
    }
}
