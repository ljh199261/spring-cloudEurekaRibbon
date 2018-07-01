package com.controller;


import com.base.BaseController;
import com.base.ResultResponse;
import com.entity.Product;
import com.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/product", produces = "application/json;charset=utf-8")
@Api(value = "产品信息接口",description = "产品信息")
@Controller
public class ProductController extends BaseController{

    @Autowired
    private ProductService productService;


    @GetMapping(value = "/selectProduct")
    @ApiOperation(value = "查询产品信息",notes = "查询产品信息")
    @ResponseBody
    public ResultResponse selectProduct(@RequestParam(required = true) Integer id){
        Product product = productService.selectById(id);

        return getResultResponse("200",product);
    }
}
