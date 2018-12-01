package com.cheer.dao;

import com.cheer.model.Order;

import java.util.List;

public interface orderMapper {
    //按商品名称查询订单
    List<Order> getOrder(String goodsName);

    //查询所有订单
    List<Order> getAllOrder(Integer orderUserId);

    //添加订单
    void addOrder(Order order);

    //取消订单
    void deleteOrder(Integer orderId);

}
