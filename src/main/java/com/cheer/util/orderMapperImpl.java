package com.cheer.util;

import com.cheer.dao.orderMapper;
import com.cheer.model.Order;

import java.util.List;

public class orderMapperImpl extends AbstractMapper implements orderMapper {
    @Override
    public List<Order> getOrder(String goodsName) {
        super.Before();
        List<Order> orderList = this.orderMapper.getOrder(goodsName);
        super.Before();
        return orderList;
    }

    @Override
    public List<Order> getAllOrder(Integer orderUserId) {
        super.Before();
        List<Order> orderList = this.orderMapper.getAllOrder(orderUserId);
        super.After();
        return orderList;
    }

    @Override
    public void addOrder(Order order) {
        super.Before();
        this.orderMapper.addOrder(order);
        super.After();
    }

    @Override
    public void deleteOrder(Integer orderId) {
        super.Before();
        this.orderMapper.deleteOrder(orderId);
        super.After();
    }
}
