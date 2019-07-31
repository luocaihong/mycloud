package com.sg.mycloud.listener;

import com.sg.mycloud.channel.DefaultProcess;
import com.sg.mycloud.vo.Product;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @ClassName MessageListener
 * @Description 定义一个消息的监听
 * @Author luocaihong
 * @Date 2019-05-17 10:39
 * @Since 1.0
 **/
@Component
//@EnableBinding(Sink.class)
@EnableBinding(DefaultProcess.class)
public class MessageListener {
//    @StreamListener(Sink.INPUT)
    @StreamListener(DefaultProcess.INPUT)
    public void input(Message<Product> message) {
        System.err.println("【*** 消息接收 ***】" + message.getPayload());
    }
}
