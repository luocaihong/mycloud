package com.sg.mycloud.mapper;

import com.sg.mycloud.vo.Product;

import java.util.List;

/**
 * @ClassName ProductMapper
 * @Description 产品对应的mapper接口
 * @Author luocaihong
 * @Date 2019-04-28 10:44
 * @Since 1.0
 **/
public interface ProductMapper {
    boolean create(Product product);
    public Product findById(Long id);
    public List<Product> findAll();
}
