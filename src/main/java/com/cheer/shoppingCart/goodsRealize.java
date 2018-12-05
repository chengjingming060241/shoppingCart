package com.cheer.shoppingCart;

import com.cheer.model.Goods;
import com.cheer.model.User;
import com.cheer.util.goodsMapperImpl;
import java.util.List;
import java.util.Scanner;

public class goodsRealize {
    Scanner sc = new Scanner(System.in);
    //获取商品实现对象
    goodsMapperImpl goodsMapper = new goodsMapperImpl();
    //获取购物车实现对象
    ShopCartRealize shopCartRealize = new ShopCartRealize();

    //根据商品名称搜索商品
    private void searchGoodsName(User user){
        System.out.println("请输入商品名称搜索相关商品名称：");
        String name = sc.next();
        goodsMapper.getgoods(name);
        System.out.println("返回上一级请按“0”，购买请按“1”");
        switch (sc.nextInt()){
            case 1:
                this.shopCartRealize.shopping(user);
                break;
            case 2:
                //返回上一级
                back(user);
        }
    }

    //根据商品价格搜索商品
    private void searchGoodsPrice(User user){
        System.out.println("请输入心仪商品的最低价格：");
        double moneyMin = sc.nextDouble();
        System.out.println("请输入心仪商品的最高价格：");
        double moneyMax = sc.nextDouble();
        goodsMapper.getGoodsPrice(moneyMin,moneyMax);
        System.out.println("返回上一级请按“0”，购买请按“1”");
        switch (sc.nextInt()){
            case 1:
                shopCartRealize.shopping(user);
                break;
            case 2:
                //返回上一级
                back(user);
        }
    }

    //获取全部商品
    private void getAllGoods(User user){
        List<Goods> goodsList = goodsMapper.getAllGoods();
        for (Goods allGoods:goodsList) {
            System.out.println(allGoods);
        }
        System.out.println("返回上一级请按“0”，购买请按“1”");
        switch (sc.nextInt()){
            case 1:
                shopCartRealize.shopping(user);
                break;
            case 0:
               shoppingGoods(user);
        }
    }

    //商品界面
    public void shoppingGoods(User user) {
        shoppingCart shoppingCart = new shoppingCart();
        for (int i = 0; i <1 ; i++) {
            System.out.println("1、浏览全部商品 \t 2、按价格查询商品 \t 3、搜索商品名称 \t 4、返回上一级请按0 ");
            String num = sc.next();
            if (num.matches("[0-4]")){
                switch (num) {
                    case "1":
                        getAllGoods(user);
                        break;
                    case "2":
                        searchGoodsPrice(user);
                        break;
                    case "3":
                        searchGoodsName(user);
                        break;
                    case "0":
                        shoppingCart.shoppingGoods(user);
                        break;
                }
            }else {
                System.out.println("0·4选择功能！");
                i--;
            }
        }


    }

    //返回商品界面的方法
    private void back(User user){
        System.out.println("返回上一级请按“0”");
        if(sc.nextInt() == 0){
            shoppingGoods(user);
        }
    }
}