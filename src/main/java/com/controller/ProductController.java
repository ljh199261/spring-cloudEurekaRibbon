package com.controller;


import com.entity.Product;
import com.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/product")
@Api(value = "产品信息接口",description = "产品信息")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/selectProduct",method =RequestMethod.GET)
    @ApiOperation(value = "查询产品信息",notes = "查询产品信息")
    @ResponseBody
    public Product selectProduct(@RequestParam(required = true) Integer id){
        Product product = productService.selectById(id);
        return product;
    }
}
