package com.sg.mycloud.service.impl;

import com.sg.mycloud.channel.DefaultProcess;
import com.sg.mycloud.service.IMessageProvider;
import com.sg.mycloud.vo.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @ClassName MessageProviderImpl
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-05-17 10:25
 * @Since 1.0
 **/
//@EnableBinding(Source.class) // 默认
@EnableBinding(DefaultProcess.class) // 自定义
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    @Qualifier("enjoy_output") //手动指定加载自定义的名称
    private MessageChannel output;  // 消息的发送管道

    @Override
    public void send(Product product) {
        output.send(MessageBuilder.withPayload(product).build());
    }
}
