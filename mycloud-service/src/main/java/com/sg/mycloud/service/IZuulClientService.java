package com.sg.mycloud.service;

import com.sg.mycloud.config.FeignClientConfig;
import com.sg.mycloud.service.fallback.IZuulClientServiceFallbackFactory;
import com.sg.mycloud.vo.Product;
import com.sg.mycloud.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName IZuulClientService
 * @Description 现在所有的服务要通过zuul的代理进行访问
 * @Author luocaihong
 * @Date 2019-05-13 17:13
 * @Since 1.0
 **/
@FeignClient(name = "MYCLOUD-ZUUL-GATEWAY",configuration = FeignClientConfig.class,
        fallbackFactory = IZuulClientServiceFallbackFactory.class)
public interface IZuulClientService {
    @RequestMapping("/mycloud-api/product-proxy/product/get/{id}")
    public Product getProduct(@PathVariable("id")long id);

    @RequestMapping("/mycloud-api/product-proxy/product/list")
    public List<Product> listProduct() ;

    @RequestMapping("/mycloud-api/product-proxy/product/add")
    public boolean addPorduct(Product product) ;

    @RequestMapping("/mycloud-api/user-proxy/user/get/{name}")
    public User getUser(@PathVariable("name")String name);
}
