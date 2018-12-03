package com.cheer.shoppingCart;


import com.cheer.model.*;
import com.cheer.util.goodsMapperImpl;
import com.cheer.util.orderMapperImpl;
import com.cheer.util.userMapperImpl;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * 订单类的方法
 */
public class orderRealoze {
    Scanner sc = new Scanner(System.in);
    //订单实现对象
    orderMapperImpl orderMapper = new orderMapperImpl();
    //购物车实现对象
    ShopCartRealize shopCartRealize = new ShopCartRealize();
    //订单对象
    Order order = new Order();
    //得到用户对象
    userMapperImpl userMapper = new userMapperImpl();
    goodsMapperImpl goodsMapper = new goodsMapperImpl();

    //获取全部订单
    private void getAllOrder(User user){
        System.out.println("-----------------目前的订单------------------");
        List<Order> orderList = orderMapper.getAllOrder(user.getUserName());
        for (Order order:orderList) {
            System.out.println(order);
        }
        System.out.println("-----------------目前的订单------------------");
        System.out.println("返回上一级请按“0”，直接购买请按“1”");
        switch (sc.nextInt()){
            case 1:
                pay(user);
                break;
            case 0:
                //返回订单界面
                back(user);
                break;
        }

    }

    //添加订单
    public void addOrder(User user){
        System.out.println("请输入要下单的商品名称");
        String orderGoodsName = sc.next();
        System.out.println("请输入寄送地址编号：");
        int orderId = sc.nextInt();
        //获取购物车信息
        ShopCart shopCart =this.shopCartRealize.purchaseGoodsMapper.getCartAnyGoods(orderGoodsName);
        if(shopCart!=null){
        //添加Id
        this.order.setOrderUserId(UUID());
        //添加订单商品名称
        this.order.setGoodsName(orderGoodsName);
        //添加订单商品数量
        this.order.setGoodsNumber(shopCart.getGoodsNumber());
        //添加订单商品价格
        this.order.setGoodsPrice(shopCart.getGoodsPrice());
        //添加地址
        //Iocation iocation = this.iocationRealize.iocationMapper.getAnyIocation(orderId,user.getUserName());
        this.order.setIocationId(orderId);
        //添加用户Id
        this.order.setOrderUserId(user.getUserId());
        //添加订单时间
        this.order.setDateTime(null);
        //添加用户名称
        this.order.setUserName(shopCart.getUserName());
        this.orderMapper.addOrder(order);
        //添加成功后删除购物车对象
        this.shopCartRealize.purchaseGoodsMapper.deleteGoods(orderGoodsName);
        }else {
            System.out.println("购物车空空如也，快去买买买吧！");
        }
        //返回订单界面
        this.shopCartRealize.back(user);
    }

    //取消订单
    private void deleteOrder(User user){
        System.out.println("请输入订单编号：");
        int orderId = sc.nextInt();
        orderMapper.deleteOrder(orderId,user.getUserName());
        //返回订单界面
        back(user);
    }

    //订单支付方法
    private void pay(User user){
        do {
            System.out.println("请输入需要下单的商品名称");
            String nameGoods = sc.next();
            //获取购物车信息
            Order order1 = this.orderMapper.getOrder(nameGoods);
            if(null!= order1){
                //得到购买商品价格总和
                double pricePay = this.orderMapper.getOrderPrice(nameGoods);
                //获取剩余余额
                double price = user.getUserMoney() - pricePay;
                user.setUserMoney(price);
                //修改用户金额
                this.userMapper.updateMoney(user);
                //获取商品库存量
                Goods goods =  this.goodsMapper.getAnyGoods(nameGoods);
                //获取购买数量
                Order order = this.orderMapper.getOrder(nameGoods);
                //得到剩余库存
                int goodsNum = goods.getGoodsNumber() - order.getGoodsNumber();
                //修改库存
                this.goodsMapper.updateGoodsNumber(goodsNum,nameGoods);
                System.out.println("一共支付"+pricePay+"元");
                System.out.println("您的余额还有"+price+"元");
            }else {
                System.out.println("购物车空空如也，快去买买买吧！");
                back(user);
            }
            System.out.println("是否继续购买？(Y/N)");
        }while("Y".equals(sc.next()));
        //返回上一级
        back(user);
    }

    //订单界面
    public void userOrder(User user){
        shoppingCart shoppingCart = new shoppingCart();
        System.out.println("1、查询订单 \t 2、取消订单 \t 0、返回上一级");
        switch (sc.nextInt()){
            case 1:
                getAllOrder(user);
                break;
            case 2:
                deleteOrder(user);
                break;
            case 0:
               shoppingCart.shoppingGoods(user);
               break;
        }
    }

    //返回订单界面
    private void back(User user){
        System.out.println("返回上一级请按“0”");
        if(sc.nextInt() == 0){
            userOrder(user);
        }
    }

    //生产UUID
    public Integer UUID(){
        Integer uuid = UUID.randomUUID().toString().hashCode();
        if(uuid < 0){
            uuid = -uuid;
        }
        return uuid;
    }
}
