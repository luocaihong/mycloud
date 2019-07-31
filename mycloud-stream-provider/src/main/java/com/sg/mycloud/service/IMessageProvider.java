package com.sg.mycloud.service;

import com.sg.mycloud.vo.Product;

/**
 * @ClassName IMessageProvider
 * @Description 定义一个消息发送接口
 * @Author luocaihong
 * @Date 2019-05-17 10:23
 * @Since 1.0
 **/
public interface IMessageProvider {
    void send(Product product);
}
