package com.sg.mycloud.service.fallback;

import com.sg.mycloud.service.IZuulClientService;
import com.sg.mycloud.vo.Product;
import com.sg.mycloud.vo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName IZuulClientServiceFallbackFactory
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-05-13 17:18
 * @Since 1.0
 **/
@Component
public class IZuulClientServiceFallbackFactory implements FallbackFactory<IZuulClientService> {
    @Override
    public IZuulClientService create(Throwable throwable) {
        return new IZuulClientService() {
            @Override
            public Product getProduct(long id) {
                Product product = new Product();
                product.setProductId(999999L);
                product.setProductName("feign-zuulName");
                product.setProductDesc("feign-zuulDesc");
                return  product;
            }

            @Override
            public List<Product> listProduct() {
                return null;
            }

            @Override
            public boolean addPorduct(Product product) {
                return false;
            }

            @Override
            public User getUser(String name) {
                User user = new User();
                user.setSex("F");
                user.setAge(17);
                user.setName("zuul-fllback："+name);
                return user;
            }
        };
    }
}
