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
    public ShopCart getCartAnyGoods(String goodsName) {
        super.Before();
        ShopCart shopCart = this.shopCartMapper.getCartAnyGoods(goodsName);
        super.After();
        return shopCart;
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

    @Override
    public double getPrice(String goodsName) {
        super.Before();
        double goodsPrice = this.shopCartMapper.getPrice(goodsName);
        return goodsPrice;
    }


}
