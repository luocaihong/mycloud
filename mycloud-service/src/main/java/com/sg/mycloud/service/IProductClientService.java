package com.sg.mycloud.service;

import com.sg.mycloud.config.FeignClientConfig;
import com.sg.mycloud.service.fallback.IProductClientServiceFallbackFactory;
import com.sg.mycloud.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName IProductClientService
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-05-08 09:49
 * @Since 1.0
 **/
@FeignClient(name = "MYCLOUD-PROVIDER-PRODUCT",configuration = FeignClientConfig.class,
fallbackFactory = IProductClientServiceFallbackFactory.class) //增加fallback降级配置
public interface IProductClientService {

    @RequestMapping("/product/get/{id}")
    public Product getProduct(@PathVariable("id") long id);

    @RequestMapping("/product/add")
    public boolean add(Product product);

    @RequestMapping("/product/list")
    public List<Product> list();
}
