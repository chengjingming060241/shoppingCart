package com.cheer.dao;


import com.cheer.model.Order;
import org.apache.ibatis.annotations.Param;
import java.util.List;


public interface orderMapper {
    //按商品名称查询订单
    Order getOrder(@Param("orderId") int orderId,@Param("orderUserName") String orderUserName);

    //查询所有订单
    List<Order> getAllOrder(String orderUserName);

    //添加订单
    void addOrder(Order order);

    //取消订单
    void deleteOrder(@Param("order") int orderId ,@Param("orderName") String orderName,@Param("orderUserName") String orderUserName);

    //获取订单价格
    double getOrderPrice(@Param("orderId") int orderId,@Param("orderUserName") String orderUserName);

    //修改订单状态
    void updateOrderState(@Param("orderState") String orderState,@Param("orderId") int orderId,@Param("orderUserName") String orderUserName);

    //查看付款记录
    List<Order> getPaymentRecord(@Param("orderState") String orderState ,@Param("orderUserName") String orderUserName);



}
