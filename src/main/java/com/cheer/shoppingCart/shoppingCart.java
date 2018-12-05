package com.cheer.shoppingCart;

import com.cheer.model.User;

import java.util.Scanner;

public class shoppingCart {

    Scanner sc = new Scanner(System.in);
    //用户对象
    userRealize userRealize = new userRealize();

    public static void main(String[] args) {
        shoppingCart shoppingCart = new shoppingCart();
        shoppingCart.home();
    }

    //登录界面
    public void home(){
        System.out.println("-----------欢迎来到其然购物中心--------------");
        System.out.println("\n1、登录 \t\t\t 2、注册账号");

        switch (sc.nextInt()){
            case 1 :
                this.userRealize.Login();
                break;
            case 2:
                this.userRealize.addID();
        }
    }

    //主界面
    public void shoppingGoods(User user){
        //商品对象
        goodsRealize goodsRealize = new goodsRealize();
        //购物车对象
        ShopCartRealize ShopCartRealize = new ShopCartRealize();
        //地址对象
        iocationRealize iocationRealize = new iocationRealize();
        //订单对象
        orderRealoze orderRealoze = new orderRealoze();

        System.out.println("1、商品 \t 2、购物车 \t 3、订单 \t 4、地址 \t 5、修改密码 \t 6、账户充值");
        switch (sc.nextInt()){
            case 1:
                goodsRealize.shoppingGoods(user);
                break;
            case 2:
                ShopCartRealize.shoppingCart(user);
                break;
            case 3:
                orderRealoze.userOrder(user);
                break;
            case 4:
                iocationRealize.shoppingIocation(user);
                break;
            case 5:
                userRealize.updatePassword(user);
                break;
            case 6:
                userRealize.updateMoney(user);
                break;
        }
    }

}
