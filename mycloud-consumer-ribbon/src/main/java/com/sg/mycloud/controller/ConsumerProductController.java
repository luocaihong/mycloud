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
import java.net.URI;
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

    public static final String PRODUCT_TOPIC = "MYCLOUD-PROVIDER-PRODUCT";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    // 获取到服务提供方的具体信息
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/product/get/{id}")
    public Object getProduct(@PathVariable long id) {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose(PRODUCT_TOPIC) ;
        System.out.println("【*** ServiceInstance ***】host = " + serviceInstance.getHost()
                        + "、port = " + serviceInstance.getPort()
                        + "、serviceId = " + serviceInstance.getServiceId());
        URI uri = URI.create(String.format("http://%s:%s/product/get/%s" , serviceInstance.getHost(), serviceInstance.getPort(), id));
        //加用户名密码访问
        Product product = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(httpHeaders), Product.class).getBody();
        return  product;
    }

    @RequestMapping("/product/list")
    public  Object listProduct() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose(PRODUCT_TOPIC) ;
        URI uri = URI.create(String.format("http://%s:%s/product/list/" , serviceInstance.getHost(), serviceInstance.getPort()));
        List<Product> list = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(httpHeaders), List.class).getBody();
        return list;
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose(PRODUCT_TOPIC) ;
        URI uri = URI.create(String.format("http://%s:%s/product/add/" , serviceInstance.getHost(), serviceInstance.getPort()));
        Boolean result = restTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<Object>(product, httpHeaders), Boolean.class).getBody();
        return result;
    }
}
