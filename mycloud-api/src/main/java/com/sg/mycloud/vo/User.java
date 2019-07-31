package com.sg.mycloud.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-05-12 15:39
 * @Since 1.0
 **/
@Getter
@Setter
@ToString
public class User implements Serializable {
    private String name;
    private int age;
    private String sex;
}
