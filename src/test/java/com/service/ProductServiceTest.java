package com.service;

import com.entity.Product;
import com.mapper.slave.ProductMapper;
import com.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * ${DESCRIPTION}
 *junit与mock的另一种单元测试写法
 * @author ljh
 * @create 2018-07-01 下午 8:26
 */
@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService = new ProductServiceImpl();

    private Product product;


    @Before
    public void setData(){
        MockitoAnnotations.initMocks(this);
        product = new Product();
    }


    @Test
    public void selectByIdTest(){
        Integer id = 2;
        when(productMapper.selectByPrimaryKey(any(Integer.class))).thenReturn(product);
        Product selectProduct = productService.selectById(2);
        Assert.assertEquals(product,selectProduct);
    }
}
