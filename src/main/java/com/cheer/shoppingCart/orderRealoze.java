package com.cheer.shoppingCart;


import com.cheer.model.*;
import com.cheer.util.goodsMapperImpl;
import com.cheer.util.orderMapperImpl;
import com.cheer.util.userMapperImpl;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 订单类的方法
 */
public class orderRealoze {

    Scanner sc = new Scanner(System.in);

    //订单实现对象
    orderMapperImpl orderMapper = new orderMapperImpl();

    //订单对象
    Order order = new Order();

    //得到用户实现对象
    userMapperImpl userMapper = new userMapperImpl();

    //获取全部订单
    private void getAllOrder(User user){

        List<Order> mapList = this.orderMapper.getAllOrder(user.getUserName());
        System.out.println("-----------------目前的订单------------------");
        for (Order order:mapList) {
            System.out.println(order);
        }
        System.out.println("-----------------目前的订单------------------");
        System.out.println("返回上一级请按“0”，付款请按“1”");
        switch (sc.nextInt()){
            case 1:
                pay(user);
                break;
            case 0:
                back(user);  //返回订单界面
                break;
        }

    }

    ////获取购买记录
       private void getPaymentRecord(User user){
          List<Order> orderList = this.orderMapper.getPaymentRecord("已付款",user.getUserName());
           for (Order order:orderList ) {
               System.out.println(order);
           }
          back(user);
       }

    //添加订单
    public void addOrder(User user){
        //购物车实现对象
        ShopCartRealize shopCartRealize = new ShopCartRealize();
        System.out.println("请输入要下单的商品名称");
        String orderGoodsName = sc.next();
        System.out.println("请输入寄送地址编号：");
        int orderId = sc.nextInt();
        //获取购物车信息

        ShopCart shopCart =shopCartRealize.purchaseGoodsMapper.getCartAnyGoods(orderGoodsName,user.getUserName());
        System.out.println("---------------------------------");
        System.out.println(shopCart);
        System.out.println("---------------------------------------------");
        if(shopCart!=null){
        //添加Id
        this.order.setOrderId(UUID());
        //添加订单商品名称
        this.order.setGoodsName(orderGoodsName);
        //添加订单商品数量
        this.order.setGoodsNumber(shopCart.getGoodsNumber());
        //添加订单商品价格
        this.order.setGoodsPrice(shopCart.getGoodsPrice());
        //添加地址
        this.order.setIocationId(orderId);
        //添加订单时间
        this.order.setDateTime(null);
        //添加用户名称
        this.order.setOrderUserName(user.getUserName());
        //添加状态
            this.order.setOrderState("未支付");
        this.orderMapper.addOrder(order);
        //添加成功后删除购物车对象
        shopCartRealize.purchaseGoodsMapper.deleteGoods(orderGoodsName,user.getUserName());
        int threadSize =10;
            ScheduledExecutorService service = Executors.newScheduledThreadPool(threadSize);
            service.schedule(new Run(this.order.getOrderId(),user.getUserName()),1, TimeUnit.MINUTES);

        }else {
            System.out.println("购物车空空如也，快去买买买吧！");
        }
        //返回订单界面
        back(user);
    }

    //取消订单
    private void deleteOrder(User user){
        System.out.println("请输入要取消的订单商品Id：");
        int orderGoodsId = sc.nextInt();
        //获取取消订单的信息
       Order order = this.orderMapper.getOrder(orderGoodsId,user.getUserName());

            if(order.getOrderState().equals("未支付")){
                this.orderMapper.updateOrderState("取消订单",orderGoodsId,user.getUserName());
                System.out.println("订单已取消！！！");
            }else if (order.getOrderState().equals("已付款")){
                this.orderMapper.updateOrderState("已退货",orderGoodsId,user.getUserName());
                double num =  order.getGoodsPrice() + user.getUserMoney() + 10;
                user.setUserMoney(num);
                this.userMapper.updateMoney(user);
                System.out.println("您已成功退货,系统自动将自动扣除运费10元，其余货款将返回到您的账户上！");
            }


    }

    //订单支付方法
    private void pay(User user){
        //获取商品实现对象
        goodsMapperImpl goodsMapper = new goodsMapperImpl();
        do {
            System.out.println("请输入需要下单的商品Id");
            int orderId = sc.nextInt();
            //获取订单信息
            Order order1 = this.orderMapper.getOrder(orderId,user.getUserName());
            if(null!= order1){
                //获取账号余额
                double price = user.getUserMoney();
                //得到购买商品价格总和
                double pricePay = this.orderMapper.getOrderPrice(orderId,user.getUserName());
                if (price < pricePay ){
                    System.out.println("商品总额"+pricePay+"元，您的余额不足请充值");
                    break;
                }else if (order1.getOrderState().equals("已付款")||order1.getOrderState().equals("取消订单")||order1.getOrderState().equals("已退货")){
                    System.out.println("此订单已冻结，请选择其他产品！");
                    break;
                } else {
                    if (pricePay>1999&&pricePay<2299){
                        System.out.println("恭喜你获得满“1999”减一百的优惠！");
                        pricePay -= 100;
                    }else if(pricePay>=2999&&pricePay<3999){
                        System.out.println("恭喜你获得满“2999”减两百的优惠！");
                        pricePay -= 200;
                    }else if(pricePay>=3999&&pricePay<4999){
                        System.out.println("恭喜你获得满“3999”减三百的优惠！");
                        pricePay -= 300;
                    }else if(pricePay>=4999){
                        System.out.println("恭喜你获得满“4999”减四百的优惠！");
                        pricePay -= 400;
                    }
                    double money = price - pricePay;
                    user.setUserMoney(money);
                    //修改用户金额
                    this.userMapper.updateMoney(user);
                    //获取商品库存量
                    Goods goods =  goodsMapper.getAnyGoods(order1.getGoodsName());
                    //获取购买数量
                    Order order = this.orderMapper.getOrder(orderId,user.getUserName());
                    //得到剩余库存
                    int goodsNum = goods.getGoodsNumber() - order.getGoodsNumber();
                    //修改库存
                    goodsMapper.updateGoodsNumber(goodsNum,order.getGoodsName());
                    //修改订单状态
                    this.orderMapper.updateOrderState("已付款",orderId,user.getUserName());
                    System.out.println("一共支付"+pricePay+"元");
                    System.out.println("您的余额还有"+money+"元");
                }
            }else {
                System.out.println("购物车空空如也，快去买买买吧！");
                back(user);
                break;
            }
            System.out.println("是否继续购买？(Y/N)");
        }while("Y".equals(sc.next()));
        back(user);   //返回上一级
    }

    //订单界面
    public void userOrder(User user){
        shoppingCart shoppingCart = new shoppingCart();
        System.out.println("1、查询订单 \t 2、取消订单 \t 3、查看购买记录 0、返回上一级");
        switch (sc.nextInt()){
            case 1:
                getAllOrder(user);
                break;
            case 2:
                deleteOrder(user);
                break;
            case 3:
                getPaymentRecord(user);
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
