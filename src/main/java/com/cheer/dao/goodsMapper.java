package com.cheer.dao;

import com.cheer.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface goodsMapper {
    //根据商品id获取商品信息
    List<Goods> getgoods(String goodsName);

    //根据商品价格获取商品
    List<Goods> getGoodsPrice(@Param("priceMin") Double priceMin ,@Param("priceMax") Double priceMax);

    //获取所以商品
    List<Goods> getAllGoods();

}
