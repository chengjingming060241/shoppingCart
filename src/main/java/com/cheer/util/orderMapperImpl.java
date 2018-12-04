package com.cheer.util;

import com.cheer.dao.orderMapper;
import com.cheer.model.Iocation;
import com.cheer.model.Order;
import com.cheer.model.User;

import java.util.List;

public class orderMapperImpl extends AbstractMapper implements orderMapper {
    @Override
    public Order getOrder(String goodsName) {
        super.Before();
        Order order = this.orderMapper.getOrder(goodsName);
        super.Before();
        return order;
    }

    @Override
    public List<Order> getAllOrder(String orderUserName) {
        super.Before();
        List<Order> orderList = this.orderMapper.getAllOrder(orderUserName);
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
    public void deleteOrder(int orderId,String orderName) {
        super.Before();
        this.orderMapper.deleteOrder(orderId,orderName);
        super.After();
    }

    @Override
    public double getOrderPrice(String goodsName) {
        super.Before();
        double orderPrice = this.orderMapper.getOrderPrice(goodsName);
        return orderPrice;
    }
}
