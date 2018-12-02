package com.cheer.util;

import com.cheer.dao.ShopCartMapper;
import com.cheer.model.ShopCart;

import java.util.List;

public class shopCartMapperImpl extends AbstractMapper implements ShopCartMapper {

    @Override
    public List<ShopCart> getAllCartGoods() {
        super.Before();
        List<ShopCart> shopCartList = this.shopCartMapper.getAllCartGoods();
        super.After();
        return shopCartList;
    }

    @Override
    public List<ShopCart> getCartGoods(String goodsName) {
        super.Before();
        List<ShopCart> shopCartList = this.shopCartMapper.getCartGoods(goodsName);
        super.After();
        return shopCartList;
    }

    @Override
    public void updateGoodsNumber(String goodsName,Integer goodsNumber) {
        super.Before();
        this.shopCartMapper.updateGoodsNumber(goodsName,goodsNumber);
        super.After();
    }

    @Override
    public void deleteGoods(String goodsName) {
        super.Before();
        this.shopCartMapper.deleteGoods(goodsName);
        super.After();
    }

    @Override
    public void deleteAllGoods() {
        super.Before();
        this.shopCartMapper.deleteAllGoods();
        super.After();
    }

    @Override
    public void addCartGoods(ShopCart shopCart) {
        super.Before();
        this.shopCartMapper.addCartGoods(shopCart);
        super.After();
    }
}
