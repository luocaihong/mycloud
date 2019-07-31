package com.sg.mycloud.controller;

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
import java.util.List;

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
    // 直接调用服务
//    public static final String PRODUCT_GET_URL = "http://localhost:8080/product/get/";
//    public static final String PRODUCT_LIST_URL="http://localhost:8080/product/list/";
//    public static final String PRODUCT_ADD_URL = "http://localhost:8080/product/add/";

    // 通过ribbon调用
    public static final String PRODUCT_GET_URL = "http://MYCLOUD-PROVIDER-PRODUCT/product/get/";
    public static final String PRODUCT_LIST_URL = "http://MYCLOUD-PROVIDER-PRODUCT/product/list/";
    public static final String PRODUCT_ADD_URL = "http://MYCLOUD-PROVIDER-PRODUCT/product/add/";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    // 获取到服务提供方的具体信息
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/product/get/{id}")
    public Object getProduct(@PathVariable long id) {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("MYCLOUD-PROVIDER-PRODUCT") ;
        System.out.println("【*** ServiceInstance ***】host = " + serviceInstance.getHost()
                        + "、port = " + serviceInstance.getPort()
                        + "、serviceId = " + serviceInstance.getServiceId());
        //未加授权前
//        Product product = restTemplate.getForObject(PRODUCT_GET_URL + id, Product.class);
        //加用户名密码访问
        Product product = restTemplate.exchange(PRODUCT_GET_URL + id, HttpMethod.GET, new HttpEntity<>(httpHeaders), Product.class).getBody();
        return  product;
    }

    @RequestMapping("/product/list")
    public  Object listProduct() {
//        List<Product> list = restTemplate.getForObject(PRODUCT_LIST_URL, List.class);
        List<Product> list = restTemplate.exchange(PRODUCT_LIST_URL, HttpMethod.GET, new HttpEntity<>(httpHeaders), List.class).getBody();
        return list;
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
//        Boolean result = restTemplate.postForObject(PRODUCT_ADD_URL, product, Boolean.class);
        Boolean result = restTemplate.exchange(PRODUCT_ADD_URL, HttpMethod.POST, new HttpEntity<Object>(product, httpHeaders), Boolean.class).getBody();
        return result;
    }
}
