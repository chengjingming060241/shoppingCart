package com.cheer.model;

import java.util.Date;

public class Goods {
    private int goodsId;
    private String name;
    private double price;
    private Date date;
    private String local;
    private int stock;

    public Goods() { }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Goods{");
        sb.append("goodsId=").append(goodsId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", date=").append(date);
        sb.append(", local='").append(local).append('\'');
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }
}
