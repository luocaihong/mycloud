package com.sg.mycloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sg.mycloud.service.IProductService;
import com.sg.mycloud.vo.Product;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
@RequestMapping("/product")
public class ProductController {
    @Resource
    private IProductService iProductService;

//    import com.netflix.discovery.DiscoveryClient;
//    import org.springframework.cloud.client.discovery.DiscoveryClient;
    @Resource
    private DiscoveryClient discoveryClient; //进行Eureka的发现服务

    @RequestMapping(value="/get/{id}")
    @HystrixCommand(fallbackMethod = "getFallback")
    public Object get(@PathVariable("id") long id) {
        Product product = this.iProductService.get(id);
        if (product == null) {
            throw new RuntimeException("该产品已经下架。");
        }
        return product;
    }

    public Object getFallback(@PathVariable("id") long id) {
        Product product = new Product();
        product.setProductName("HystrixName");
        product.setProductDesc("HystrixDesc");
        product.setProductId(0L);
        return product;
    }

    @RequestMapping(value="/add", method = {RequestMethod.POST, RequestMethod.GET})
    public Object add(@RequestBody Product product) {
        return this.iProductService.add(product) ;
    }

    @RequestMapping(value="/list")
    public Object list() {
        return this.iProductService.list() ;
    }

    @RequestMapping(value = "/discover")
    public Object discover() {
        return discoveryClient;
    }
}
