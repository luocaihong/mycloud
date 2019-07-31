package com.sg.mycloud.service.impl;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.sg.mycloud.mapper.ProductMapper;
import com.sg.mycloud.service.IProductService;
import com.sg.mycloud.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-04-28 11:09
 * @Since 1.0
 **/
@Service
public class ProductServiceImpl implements IProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public Product get(long id) {
        return productMapper.findById(id);
    }

    @Override
    public boolean add(Product product) {
        return productMapper.create(product);
    }

    @Override
    public List<Product> list() {
        return productMapper.findAll();
    }
}
