package com.cheer.shoppingCart;

import java.util.Scanner;

public class shoppingCart {

    Scanner sc = new Scanner(System.in);
    //用户对象
    userRealize userRealize = new userRealize();
    //商品对象
    goodsRealize goodsRealize = new goodsRealize();
    //购物车对象
    ShopCartRealize ShopCartRealize = new ShopCartRealize();
    //地址对象
    iocationRealize iocationRealize = new iocationRealize();
    //订单对象
    orderRealoze orderRealoze = new orderRealoze();

    public static void main(String[] args) {
        shoppingCart shoppingCart = new shoppingCart();
        shoppingCart.home();
    }

    //登录界面
    public void home(){
        System.out.println("-----------欢迎来到其然购物中心--------------");
        System.out.println("\n1、登录 \t\t\t 2、注册账号");
        int num = sc.nextInt();
        switch (num){
            case 1 :
                userRealize.Login();
                break;

            case 2:
                userRealize.addID();
        }
    }

    //主界面
    public void shoppingGoods(){
        System.out.println("1、商品 \t 2、购物车 \t 3、订单 \t 4、地址 \t 5、修改密码");
        switch (sc.nextInt()){
            case 1:
                goodsRealize.shoppingGoods();
                break;
            case 2:
                ShopCartRealize.shoppingCart();
                break;
            case 3:
                orderRealoze.userOrder();
            case 4:
                iocationRealize.shoppingIocation();
            case 5:
                userRealize.updatePassword();
        }
    }

}
