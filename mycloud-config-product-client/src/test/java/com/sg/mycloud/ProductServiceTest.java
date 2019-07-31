package com.sg.mycloud;

import com.sg.mycloud.service.IProductService;
import com.sg.mycloud.vo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName ProductServiceTest
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-04-28 11:14
 * @Since 1.0
 **/
@SpringBootTest(classes = ProductConfigApp.class)
@RunWith(SpringRunner.class)
public class ProductServiceTest {
    @Resource
    private IProductService productService;

    @Test
    public void testGet(){
        System.out.println(productService.get(1));
    }

    @Test
    public void testAdd(){
        Product product = new Product();
        product.setProductName("红楼梦");
        product.setProductDesc("曹雪芹");
        System.out.println(productService.add(product));
    }

    @Test
    public void testList(){
        System.out.println(productService.list());
    }
}
