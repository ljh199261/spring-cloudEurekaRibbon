package com.service.impl;

import com.entity.Orders;
import com.mapper.slave.OrdersMapper;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public Orders selectById(Integer oid) {
        Orders orders = ordersMapper.selectByPrimaryKey(oid);
        return orders;
    }
}
