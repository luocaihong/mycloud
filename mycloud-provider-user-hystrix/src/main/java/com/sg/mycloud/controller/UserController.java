package com.sg.mycloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sg.mycloud.vo.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName ProductController
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-04-28 13:34
 * @Since 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/get/{name}")
    @HystrixCommand
    public Object get(@PathVariable("name") String name) {
        User users = new User();
        users.setName(name);
        users.setAge(18);
        users.setSex("F");
        return users;
    }
}