package com.service;

import com.entity.Orders;

public interface OrderService {
    /**
     * 根据id查询
     * @param oid
     * @return
     */
    Orders selectById(Integer oid);

}
