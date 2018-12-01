package com.cheer.model;

import java.util.Date;

public class Order {
    private int orderId;
    private String goodsName;
    private int goodsNumber;
    private double goodsPrice;
    private String iocation;
    private int orderUserId;
    private Date dateTime;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public String getIocation() {
        return iocation;
    }

    public void setIocation(String iocation) {
        this.iocation = iocation;
    }

    public int getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(int orderUserId) {
        this.orderUserId = orderUserId;
    }

    public Date getDate() {
        return dateTime;
    }

    public void setDate(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("orderId=").append(orderId);
        sb.append(", goodsName='").append(goodsName).append('\'');
        sb.append(", goodsNumber=").append(goodsNumber);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", iocation='").append(iocation).append('\'');
        sb.append(", orderUserId=").append(orderUserId);
        sb.append(", date=").append(dateTime);
        sb.append('}');
        return sb.toString();
    }
}
