package com.cheer.dao;

import com.cheer.model.ShopCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购买商品的接口
 */
public interface ShopCartMapper {

    //查看所有购物车商品
    List<ShopCart> getAllCartGoods();

    //按商品名称查看购物车商品
    List<ShopCart> getCartGoods(String goodsName);

    //修改已选商品数量
    void updateGoodsNumber(@Param("goodsName") String goodsName,@Param("goodsNumber") Integer goodsNumber );

    //删除已选商品
    void deleteGoods(String goodsName);

    //清空购物车
    void deleteAllGoods();

    //添加购物车
    void addCartGoods(ShopCart shopCart);

}
