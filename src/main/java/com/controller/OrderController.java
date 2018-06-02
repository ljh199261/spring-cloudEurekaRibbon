package com.controller;


import com.entity.Orders;
import com.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/order")
@Controller
@Api(value = "订单接口" ,description = "订单查询")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/selectOder/{id}")
    @ApiOperation(value = "订单信息",notes = "订单信息")
    @ResponseBody
    public Orders selectOder(@PathVariable Integer id){
        Orders orders = orderService.selectById(id);
        return orders;
    }
}
