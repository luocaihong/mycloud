package com.sg.mycloud.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName Product
 * @Description 产品pojo
 * @Author luocaihong
 * @Date 2019-04-28 10:10
 * @Since 1.0
 **/
@Getter
@Setter
@ToString
public class Product implements Serializable {
    private Long productId;
    private String productName;
    private String productDesc;
}
