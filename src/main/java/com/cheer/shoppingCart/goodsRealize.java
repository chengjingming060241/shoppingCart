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
        goodsRealize.getAllGoods();

    }
    //根据商品名称搜索商品
    public void searchGoodsName(){
        System.out.println("请输入商品名称搜索相关商品名称：");
        String name = sc.next();
        goodsMapper.getgoods(name);
    }

    //根据商品价格搜索商品
    public void searchGoodsPrice(){
        System.out.println("请输入心仪商品的最低价格：");
        double moneyMin = sc.nextDouble();
        System.out.println("请输入心仪商品的最高价格：");
        double moneyMax = sc.nextDouble();
        goodsMapper.getGoodsPrice(moneyMin,moneyMax);
    }

    //获取全部商品
    public void getAllGoods(){
        List<Goods> goodsList = goodsMapper.getAllGoods();
        for (Goods allGoods:goodsList) {
            System.out.println(allGoods);
        }
    }
}
