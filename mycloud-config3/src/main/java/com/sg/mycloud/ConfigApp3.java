package com.sg.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName ConfigApp
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-05-14 21:16
 * @Since 1.0
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigApp3 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApp3.class, args);
    }
}
