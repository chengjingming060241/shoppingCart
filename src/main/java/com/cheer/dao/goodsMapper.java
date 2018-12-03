package com.cheer.dao;

import com.cheer.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface goodsMapper {
    //根据商品名称获取商品信息 模糊查询
    List<Goods> getgoods(String goodsName);

    //根据商品价格区间获取商品
    List<Goods> getGoodsPrice(@Param("priceMin") Double priceMin ,@Param("priceMax") Double priceMax);

    //获取所以商品
    List<Goods> getAllGoods();

    //获取单个商品信息
    Goods getAnyGoods(@Param("goodsName") String goodsName);

    //修改商品库存
    void updateGoodsNumber(@Param("goodsNumber")int goodsNumber,@Param("goodsName")String goodsName);

}
