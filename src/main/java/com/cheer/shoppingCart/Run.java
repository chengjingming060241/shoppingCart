package com.cheer.shoppingCart;

import com.cheer.model.User;
import com.cheer.util.orderMapperImpl;

//创建线程控制订单属性
public class Run implements Runnable {
    private int orderId;
    private String userName;
    orderMapperImpl orderMapper = new orderMapperImpl();

    public Run(int orderId, String userName) {
        this.orderId = orderId;
        this.userName = userName;
    }

    @Override
    public void run() {
        this.orderMapper.updateOrderState("取消订单",getOrderId(),getUserName());
        System.out.println("订单取消了！！！");
        shoppingCart shoppingCart = new shoppingCart();
        User user = new User();
        shoppingCart.shoppingGoods(user);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
