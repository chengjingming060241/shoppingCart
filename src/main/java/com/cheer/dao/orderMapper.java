package com.cheer.dao;

import com.cheer.model.Iocation;
import com.cheer.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface orderMapper {
    //按商品名称查询订单
    Order getOrder(String goodsName);

    //查询所有订单
    List<Order> getAllOrder(@Param("orderUserName") String orderUserName);

    //添加订单
    void addOrder(Order order);

    //取消订单
    void deleteOrder(@Param("order") int orderId ,@Param("orderName") String orderName);

    //获取订单价格
    double getOrderPrice(String goodsName);

}
