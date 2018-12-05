package com.cheer.util;

import com.cheer.dao.ShopCartMapper;
import com.cheer.model.ShopCart;


import java.util.List;

public class shopCartMapperImpl extends AbstractMapper implements ShopCartMapper {

    @Override
    public List<ShopCart> getAllCartGoods(String userName) {
        super.Before();
        List<ShopCart> shopCartList = this.shopCartMapper.getAllCartGoods(userName);
        super.After();
        return shopCartList;
    }

    @Override
    public ShopCart getCartAnyGoods( String goodsName,String userName) {
        super.Before();
        ShopCart shopCart = this.shopCartMapper.getCartAnyGoods(goodsName,userName);
        super.After();
        return shopCart;
    }


    @Override
    public void updateGoodsNumber(String goodsName,Integer goodsNumber,String userName) {
        super.Before();
        this.shopCartMapper.updateGoodsNumber(goodsName,goodsNumber,userName);
        super.After();
    }

    @Override
    public void deleteGoods(String goodsName,String userName) {
        super.Before();
        this.shopCartMapper.deleteGoods(goodsName,userName);
        super.After();
    }

    @Override
    public void deleteAllGoods(String userName) {
        super.Before();
        this.shopCartMapper.deleteAllGoods(userName);
        super.After();
    }

    @Override
    public void addCartGoods(ShopCart shopCart) {
        super.Before();
        this.shopCartMapper.addCartGoods(shopCart);
        super.After();
    }

    @Override
    public double getPrice(String goodsName,String userName) {
        super.Before();
        double goodsPrice = this.shopCartMapper.getPrice(goodsName,userName);
        return goodsPrice;
    }


}
