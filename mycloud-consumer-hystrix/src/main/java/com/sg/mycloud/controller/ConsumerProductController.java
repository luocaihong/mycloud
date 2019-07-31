package com.sg.mycloud.controller;

import com.sg.mycloud.service.IProductClientService;
import com.sg.mycloud.service.IZuulClientService;
import com.sg.mycloud.vo.Product;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName ConsumerProductController
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-04-28 13:43
 * @Since 1.0
 **/
@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {

    @Resource
    private IProductClientService iProductClientService;

    @Resource
    private IZuulClientService iZuulClientService;

    @RequestMapping("/product/get/{id}")
    public Object getProduct(@PathVariable long id) {
        return iProductClientService.getProduct(id);
    }

    @RequestMapping("/product/list")
    public  Object listProduct() {
        return iProductClientService.list();
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        return iProductClientService.add(product);
    }

    @RequestMapping("/product/getProductAndUser")
    public Object getProductAndUser(long id) {
        Map<String,Object> result = new HashMap();
        result.put("product",iZuulClientService.getProduct(id));
        result.put("user",iZuulClientService.getUser(id+""));
        return  result;
    }
}
