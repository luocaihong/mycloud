package com.sg.mycloud.service;

import com.sg.mycloud.vo.Product;

import java.util.List;

/**
 * @ClassName IProductService
 * @Description TODO
 * @Author luocaihong
 * @Date 2019-04-28 11:08
 * @Since 1.0
 **/
public interface IProductService {
    Product get(long id);
    boolean add(Product product);
    List<Product> list();
}
