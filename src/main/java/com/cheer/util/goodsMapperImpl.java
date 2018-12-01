package com.cheer.util;

import com.cheer.dao.goodsMapper;
import com.cheer.model.Goods;

import java.util.List;

public class goodsMapperImpl extends AbstractMapper implements goodsMapper {
    @Override
    public List<Goods> getgoods(String goodsName) {
        super.Before();
        List<Goods> goodsList = this.goodsMapper.getgoods(goodsName);
        super.After();
        return goodsList;
    }

    @Override
    public List<Goods> getGoodsPrice(Double priceMin, Double priceMax) {
        super.Before();
        List<Goods>goodsList =  this.goodsMapper.getGoodsPrice(priceMin,priceMax);
        super.After();
        return goodsList;
    }

    @Override
    public List<Goods> getAllGoods() {
        super.Before();
        List<Goods>goodsListAll = this.goodsMapper.getAllGoods();
        super.After();
        return goodsListAll;
    }


}
