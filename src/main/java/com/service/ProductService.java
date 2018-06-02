package com.service;

import com.entity.Product;

public interface ProductService {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    Product selectById(Integer id);
}
