package com.service.impl;

import com.entity.Product;
import com.mapper.slave.ProductMapper;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public Product selectById(Integer id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }
}
