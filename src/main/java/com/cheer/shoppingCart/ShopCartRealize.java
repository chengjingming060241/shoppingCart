package com.cheer.shoppingCart;



import com.cheer.model.ShopCart;
import com.cheer.util.shopCartMapperImpl;

import java.util.List;
import java.util.Scanner;

/**
 * 购买商品的方法
 */
public class ShopCartRealize {
    Scanner sc = new Scanner(System.in);
    shopCartMapperImpl purchaseGoodsMapper = new shopCartMapperImpl();

    public static void main(String[] args) {
        shopCartMapperImpl purchaseGoodsMapper1 = new shopCartMapperImpl();
        ShopCart shopCart = new ShopCart();
        shopCart.setShopId(2);
        shopCart.setGoodsName("iphoneX");
        shopCart.setGoodsNumber(10);
        shopCart.setGoodsPrice(5800.00);
        shopCart.setUserName("chengjingming");
        purchaseGoodsMapper1.addCartGoods(shopCart);


    }
    //查询所有购物车商品
    private void getAllCartGoods(){
        List<ShopCart> shopCartList =this.purchaseGoodsMapper.getAllCartGoods();
        for (ShopCart cartGoods: shopCartList) {
            System.out.println(cartGoods);
        }
        //返回上一级
        back();
    }

    //按商品名称查询购物车商品
    private void getCartGoods(){
        System.out.println("请输入商品名称：");
        String goodsName = sc.next();
        List<ShopCart> shopCartList =this.purchaseGoodsMapper.getCartGoods(goodsName);
        for (ShopCart cartGoods: shopCartList) {
            System.out.println(cartGoods);
        }
        //返回上一级
        back();
    }

    //修改购物车商品数量
    private void updateCartGoodsNumber(){
        System.out.println("请输入商品名称：");
        String goodsName = sc.next();
        System.out.println("请输入商品数量：");
        int goodsNumber = sc.nextInt();
        this.purchaseGoodsMapper.updateGoodsNumber(goodsName,goodsNumber);
        System.out.println("修改成功");
        back();
    }

    //删除购物车商品
    private void deleteCartGoods(){
        System.out.println("请输入商品名称：");
        String goodsName = sc.next();
        this.purchaseGoodsMapper.deleteGoods(goodsName);
        System.out.println("商品删除成功");
        //返回上一级
        back();
    }
    //清空购物车 --最后测试
    private void deleteAllGoods(){
        System.out.println("是否清空购物车（N/Y）");
        String delete = sc.next();
        if (delete.equals("Y")){
            this.purchaseGoodsMapper.deleteAllGoods();
        }
        //返回上一级
        back();
    }
    //购物车界面
    public void shoppingCart(){
        shoppingCart shoppingCart = new shoppingCart();
            System.out.println("1、查看购物车商品 \t 2、结算 \t 3、修改商品数量 \t 4、删除购物车商品 \t 5、清空购物车 \t 0、返回上一级");
            switch (sc.nextInt()){
                case 1:
                    getAllCartGoods();
                    break;
                case 2:
                    System.out.println("建设中-------");
                    back();
                case 3:
                    updateCartGoodsNumber();
                case 4:
                    deleteCartGoods();
                case 5:
                    deleteAllGoods();
                case 0:
                    shoppingCart.shoppingGoods();
            }

    }
    //返回购物车界面的方法
    private void back(){
        System.out.println("返回上一级请按“0”");
        if(sc.nextInt() == 0){
            shoppingCart();
        }
    }
}
