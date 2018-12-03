package com.cheer.model;

import java.util.Date;

public class Order {
    private int orderId;
    private String goodsName;
    private int goodsNumber;
    private double goodsPrice;
    private int iocationId;
    private int orderUserId;
    private Date dateTime;
    private String userName;
    private Iocation iocat;

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

    public int getIocationId() {
        return iocationId;
    }

    public void setIocationId(int iocationId) {
        this.iocationId = iocationId;
    }

    public int getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(int orderUserId) {
        this.orderUserId = orderUserId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Iocation getIocat() {
        return iocat;
    }

    public void setIocat(Iocation iocat) {
        this.iocat = iocat;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("orderId=").append(orderId);
        sb.append(", goodsName='").append(goodsName).append('\'');
        sb.append(", goodsNumber=").append(goodsNumber);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", iocationId=").append(iocationId);
        sb.append(", orderUserId=").append(orderUserId);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", iocat=").append(iocat);
        sb.append('}');
        return sb.toString();
    }
}
