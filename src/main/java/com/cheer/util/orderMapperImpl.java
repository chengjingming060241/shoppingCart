package com.cheer.util;

import com.cheer.dao.orderMapper;
import com.cheer.model.Iocation;
import com.cheer.model.Order;
import com.cheer.model.User;

import java.util.List;
import java.util.Map;

public class orderMapperImpl extends AbstractMapper implements orderMapper {
    @Override
    public Order getOrder(int orderId,String orderUserName) {
        super.Before();
        Order order = this.orderMapper.getOrder(orderId,orderUserName);
        super.Before();
        return order;
    }

    @Override
    public List<Order> getAllOrder(String orderUserName) {
        super.Before();
        List<Order> mapList = this.orderMapper.getAllOrder(orderUserName);
        super.After();
        return mapList;
    }


    @Override
    public void addOrder(Order order) {
        super.Before();
        this.orderMapper.addOrder(order);
        super.After();
    }

    @Override
    public void deleteOrder(int orderId,String orderName,String orderUserName) {
        super.Before();
        this.orderMapper.deleteOrder(orderId,orderName,orderUserName);
        super.After();
    }

    @Override
    public double getOrderPrice(int orderId,String orderUserName ) {
        super.Before();
        double orderPrice = this.orderMapper.getOrderPrice(orderId,orderUserName);
        return orderPrice;
    }

    @Override
    public void updateOrderState(String orderState, int orderId,String orderUserName) {
        super.Before();
        this.orderMapper.updateOrderState(orderState,orderId,orderUserName);
        super.After();
    }

    @Override
    public List<Order> getPaymentRecord(String orderState,String orderUserName) {
        super.Before();
        List<Order> orderList = this.orderMapper.getPaymentRecord(orderState,orderUserName);
        return orderList;
    }
}
