package com.sg.mycloud.service.fallback;

import com.sg.mycloud.service.IProductClientService;
import com.sg.mycloud.vo.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName IProductClientServiceFallbackFactory
 * @Description IProductClientService的失败调用(降级处理)
 * @Author luocaihong
 * @Date 2019-05-12 14:27
 * @Since 1.0
 **/
@Component
public class IProductClientServiceFallbackFactory implements FallbackFactory<IProductClientService> {
    @Override
    public IProductClientService create(Throwable throwable) {
        return new IProductClientService() {
            @Override
            public Product getProduct(long id) {
                Product product = new Product();
                product.setProductId(999999L);
                product.setProductName("feign-hystrixName");
                product.setProductDesc("feign-hystrixDesc");
                return  product;
            }

            @Override
            public boolean add(Product product) {
                return false;
            }

            @Override
            public List<Product> list() {
                return null;
            }
        };
    }
}
