package com.sg.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @ClassName TurbineApp
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-05-12 16:01
 * @Since 1.0
 **/
@SpringBootApplication
@EnableTurbine
public class TurbineApp {
    public static void main(String[] args) {
        SpringApplication.run(TurbineApp.class,args);
    }
}
