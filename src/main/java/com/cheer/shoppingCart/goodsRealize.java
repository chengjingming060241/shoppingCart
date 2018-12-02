package com.cheer.shoppingCart;

import com.cheer.model.Goods;
import com.cheer.util.goodsMapperImpl;

import java.util.List;
import java.util.Scanner;

public class goodsRealize {
    Scanner sc = new Scanner(System.in);
    goodsMapperImpl goodsMapper = new goodsMapperImpl();
    public static void main(String[] args) {
        goodsRealize goodsRealize = new goodsRealize();
        goodsRealize.searchGoodsName();

    }
    //根据商品名称搜索商品
    private void searchGoodsName(){
        System.out.println("请输入商品名称搜索相关商品名称：");
        String name = sc.next();
        goodsMapper.getgoods(name);
        //返回商品界面
        back();
    }

    //根据商品价格搜索商品
    private void searchGoodsPrice(){
        System.out.println("请输入心仪商品的最低价格：");
        double moneyMin = sc.nextDouble();
        System.out.println("请输入心仪商品的最高价格：");
        double moneyMax = sc.nextDouble();
        goodsMapper.getGoodsPrice(moneyMin,moneyMax);
        //返回商品界面
        back();
    }

    //获取全部商品
    private void getAllGoods(){
        List<Goods> goodsList = goodsMapper.getAllGoods();
        for (Goods allGoods:goodsList) {
            System.out.println(allGoods);
        }
        //返回商品界面
        back();
    }
    //商品界面
    public void shoppingGoods() {
        shoppingCart shoppingCart = new shoppingCart();
        System.out.println("1、浏览全部商品 \t 2、按价格查询商品 \t 3、搜索商品名称 \t 4、返回上一级请按0 ");
        switch (sc.nextInt()) {
            case 1:
                getAllGoods();
                break;
            case 2:
                searchGoodsPrice();
                break;
            case 3:
                searchGoodsName();
                break;
            case 0:
                shoppingCart.shoppingGoods();
                break;
        }
    }

    //返回购物车界面的方法
    private void back(){
        System.out.println("返回上一级请按“0”");
        if(sc.nextInt() == 0){
            shoppingGoods();
        }
    }
}