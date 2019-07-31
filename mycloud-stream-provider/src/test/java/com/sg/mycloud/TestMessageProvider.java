package com.sg.mycloud;

import com.sg.mycloud.service.IMessageProvider;
import com.sg.mycloud.vo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName TestMessageProvider
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-05-17 10:28
 * @Since 1.0
 **/
@SpringBootTest(classes = StreamProviderApp.class)
@RunWith(SpringRunner.class)
public class TestMessageProvider {
    @Resource
    private IMessageProvider messageProvider;

    @Test
    public void testSend() {
        Product product = new Product();
        product.setProductId(1L);
        product.setProductName("messageName");
        product.setProductDesc("desc");
        messageProvider.send(product);
    }
}
