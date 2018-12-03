package com.cheer.model;

public class ShopCart {
        //购买商品id
        private int shopId;
        //商品名称
        private String goodsName;
        //商品数量
        private int goodsNumber;
        //商品价格
        private double goodsPrice;
        //购买商品用户名称
        private String UserName;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ShopCart{");
        sb.append("shopId=").append(shopId);
        sb.append(", goodsName='").append(goodsName).append('\'');
        sb.append(", goodsNumber=").append(goodsNumber);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", UserName='").append(UserName).append('\'');
        sb.append('}');
        return sb.toString();
    }




}
