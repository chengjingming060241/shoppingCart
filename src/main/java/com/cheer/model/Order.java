package com.cheer.model;

import java.util.Date;

public class Order {
    private int orderId;
    private String goodsName;
    private int goodsNumber;
    private double goodsPrice;
    private int iocationId;
    private Date dateTime;
    private String orderUserName;
    private Iocation iocation;
    private String orderState;

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    public Iocation getIocat() {
        return iocation;
    }

    public void setIocat(Iocation iocat) {
        this.iocation = iocat;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("orderId=").append(orderId);
        sb.append(", goodsName='").append(goodsName).append('\'');
        sb.append(", goodsNumber=").append(goodsNumber);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", iocationId=").append(iocationId);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", orderUserName='").append(orderUserName).append('\'');
        sb.append(", iocat=").append(iocation);
        sb.append(", orderState='").append(orderState).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
