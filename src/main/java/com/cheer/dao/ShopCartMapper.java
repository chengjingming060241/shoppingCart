package com.cheer.dao;

import com.cheer.model.ShopCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购买商品的接口
 */
public interface ShopCartMapper {

    //查看所有购物车商品
    List<ShopCart> getAllCartGoods(String userName);

    //按商品名称查看一条购物车商品信息
    ShopCart getCartAnyGoods(@Param("goodsName") String goodsName,@Param("userName") String userName);

    //修改已选商品数量
    void updateGoodsNumber(@Param("goodsName") String goodsName,@Param("goodsNumber") Integer goodsNumber , @Param("userName") String userName);

    //删除已选商品
    void deleteGoods(@Param("goodsName") String goodsName,@Param("userName") String userName);

    //清空购物车
    void deleteAllGoods(String userName);

    //添加购物车
    void addCartGoods(ShopCart shopCart);

    //按商品名获取价格
    double getPrice(@Param("goodsName") String goodsName,@Param("userName") String userName);

}
