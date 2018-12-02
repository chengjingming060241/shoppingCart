package com.cheer.shoppingCart;

import com.cheer.util.orderMapperImpl;

import java.util.Scanner;

/**
 * 订单类的方法
 */
public class orderRealoze {
    Scanner sc = new Scanner(System.in);
    orderMapperImpl orderMapper = new orderMapperImpl();
    public static void main(String[] args) {
        orderRealoze orderRealoze = new orderRealoze();
        orderRealoze.getAllrder();
    }
    //获取当前用户订单
    private void getAllrder(){
        System.out.println("请输入账号名称：");
        String userName = sc.next();
        orderMapper.getAllOrder(userName);
        //返回订单界面
        back();
    }

    //添加订单
    private void addOrder(){

        //返回订单界面
        back();
    }

    //取消订单
    private void deleteOrder(){
        System.out.println("请输入订单编号：");
        int orderId = sc.nextInt();
        orderMapper.deleteOrder(orderId);
        //返回订单界面
        back();
    }

    //订单界面
    public void userOrder(){
        shoppingCart shoppingCart = new shoppingCart();
        System.out.println("1、查询订单 \t 2、取消订单 \t 0、返回上一级");
        switch (sc.nextInt()){
            case 1:
                getAllrder();
                break;
            case 2:
                deleteOrder();
                break;
            case 0:
               shoppingCart.shoppingGoods();
        }
    }

    private void back(){
        System.out.println("返回上一级请按“0”");
        if(sc.nextInt() == 0){
            userOrder();
        }
    }
}
