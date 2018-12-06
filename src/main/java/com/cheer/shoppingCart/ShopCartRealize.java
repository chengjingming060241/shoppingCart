package com.cheer.shoppingCart;
import com.cheer.model.Goods;
import com.cheer.model.Order;
import com.cheer.model.ShopCart;
import com.cheer.model.User;
import com.cheer.util.goodsMapperImpl;
import com.cheer.util.orderMapperImpl;
import com.cheer.util.shopCartMapperImpl;
import com.cheer.util.userMapperImpl;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
/**
 * 购买商品的方法
 */
public class ShopCartRealize {
    Scanner sc = new Scanner(System.in);
    //购物车实现对象
    shopCartMapperImpl purchaseGoodsMapper = new shopCartMapperImpl();
    //用户对象
    userMapperImpl userMapper = new userMapperImpl();
    //购物车对象
    ShopCart shopCart = new ShopCart();
    //商品实现对象
    goodsMapperImpl goodsMapper = new goodsMapperImpl();
    //订单实现对象
    orderRealoze orderRealoze = new orderRealoze();
    //获取订单对象
    orderMapperImpl orderMapper = new orderMapperImpl();

    //查询所有购物车商品
    private void getAllCartGoods(User user){
        List<ShopCart> shopCartList = this.purchaseGoodsMapper.getAllCartGoods(user.getUserName());
        for (ShopCart s:shopCartList) {
            System.out.println(s);
        }
        for (int i = 0; i <1 ; i++) {
            System.out.println("返回上一级请按“0”，直接购买请按“1”，下单请按“2”");
            String num = sc.next();
            if (num.matches("[0-2]")){
                switch (num){
                    case "1":
                        pay(user);
                        break;
                    case "2":
                        orderRealoze.addOrder(user);
                        break;
                    case "0":
                      shoppingCart(user);
                        break;
                }
            }else {
                System.out.println("0·2选择相应功能");
                i--;
            }
        }

    }

    //修改购物车商品数量
    private void updateCartGoodsNumber(User user){
        System.out.println("请输入商品名称：");
        String goodsName = sc.next();
        System.out.println("请输入商品数量：");
        int goodsNumber = sc.nextInt();
        this.purchaseGoodsMapper.updateGoodsNumber(goodsName,goodsNumber,user.getUserName());
        System.out.println("修改成功");
        back(user);
    }

    //删除购物车商品
    private void deleteCartGoods(User user){
        System.out.println("请输入商品名称：");
        String goodsName = sc.next();
        this.purchaseGoodsMapper.deleteGoods(goodsName,user.getUserName());
        System.out.println("商品删除成功");
        //返回上一级
        back(user);
    }

    //清空购物车 --最后测试
    private void deleteAllGoods(User user){
        System.out.println("是否清空购物车（N/Y）");
        String delete = sc.next();
        if (delete.equals("Y")){
            this.purchaseGoodsMapper.deleteAllGoods(user.getUserName());
        }
        //返回上一级
        back(user);
    }

    //支付的方法
    private void pay(User user){
        do {
            System.out.println("请输入需要购买的商品名称");
            String nameGoods = sc.next();
            System.out.println("请输入寄送地址编号：");
            int orderId = sc.nextInt();
            //获取购物车信息
            ShopCart shop =this.purchaseGoodsMapper.getCartAnyGoods(nameGoods,user.getUserName());
            if(null!= shop){
            //得到购买商品价格总和
            double pricePay = this.purchaseGoodsMapper.getPrice(nameGoods,user.getUserName());
            //获取剩余余额
            double price = user.getUserMoney();
            if (price<pricePay){
                System.out.println("商品总额"+pricePay+"元，您的余额不足请充值");
                break;
            }else {
                //获取商品库存量
                Goods goods =  this.goodsMapper.getAnyGoods(nameGoods);
                //获取购买数量
                ShopCart shopCart =  this.purchaseGoodsMapper.getCartAnyGoods(nameGoods,user.getUserName());
                //得到剩余库存
                int goodsNum = goods.getGoodsNumber() - shopCart.getGoodsNumber();
                //修改库存
                this.goodsMapper.updateGoodsNumber(goodsNum,nameGoods);
                //创建订单对象
                Order order = new Order();
                //添加订单Id
                order.setOrderId(UUID());
                //添加状态
                order.setOrderState("已付款");
                //添加用户名
                order.setOrderUserName(user.getUserName());
                //添加地址编号
                order.setIocationId(orderId);
                //添加下单时间
                order.setDateTime(null);
                //添加商品名称
                order.setGoodsName(nameGoods);
                //添加商品数量
                order.setGoodsNumber(shop.getGoodsNumber());
                //添加商品总价
                order.setGoodsPrice(pricePay);
               this.orderMapper.addOrder(order);
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
                user.setUserMoney(price);
                //修改用户金额
                this.userMapper.updateMoney(user);
                //删除支付物品对象
                this.purchaseGoodsMapper.deleteGoods(nameGoods,user.getUserName());

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

    //添加商品的方法
    public void shopping(User user){
        do {
            System.out.println("输入需要购买商品的名称");
            String goodsName = sc.next();
            System.out.println("数量");
            int goodsNumber = sc.nextInt();
            //获取商品信息
            Goods goods = this.goodsMapper.getAnyGoods(goodsName);
            //按商品名称获取购物车商品信息
            ShopCart shopCart1 = this.purchaseGoodsMapper.getCartAnyGoods(goodsName,user.getUserName());
            //判断库存
            if(goods.getGoodsNumber()> goodsNumber){
                //判断购物车是否有该商品信息
                if (shopCart1!=null){
                    //判断是否有相同商品，有就修改商品数量，没有就添加商品
                    if (goodsName.equals(shopCart1.getGoodsName()) ){
                        int goodsNumber1 = goodsNumber + shopCart1.getGoodsNumber();
                        this.purchaseGoodsMapper.updateGoodsNumber(shopCart1.getGoodsName(),goodsNumber1,user.getUserName());
                        System.out.println("添加成功！");
                        break;
                    }else  {
                        //添加ID
                        this.shopCart.setShopId(UUID());
                        //添加商品名称
                        this.shopCart.setGoodsName(goodsName);
                        //添加商品价格
                        this.shopCart.setGoodsPrice(goods.getGoodsPrice());
                        //添加商品数量
                        this.shopCart.setGoodsNumber(goodsNumber);
                        //获取用户名称
                        this.shopCart.setUserName(user.getUserName());
                        //添加到购物车
                        this.purchaseGoodsMapper.addCartGoods(shopCart);
                        System.out.println("购买成功！");
                        break;
                    }
                }else {
                    //添加ID
                    this.shopCart.setShopId(UUID());
                    //添加商品名称
                    this.shopCart.setGoodsName(goodsName);
                    //添加商品价格
                    this.shopCart.setGoodsPrice(goods.getGoodsPrice());
                    //添加商品数量
                    this.shopCart.setGoodsNumber(goodsNumber);
                    //获取用户名称
                    this.shopCart.setUserName(user.getUserName());
                    //添加到购物车
                    this.purchaseGoodsMapper.addCartGoods(shopCart);
                    System.out.println("购买成功！");

                     }
            } else {
                System.out.println("库存不足，已默认选择最大库存量！");
                goodsNumber = goods.getGoodsNumber();
                //添加ID
                this.shopCart.setShopId(UUID());
                //添加商品名称
                this.shopCart.setGoodsName(goodsName);
                //添加商品价格
                this.shopCart.setGoodsPrice(goods.getGoodsPrice());
                //添加商品数量
                this.shopCart.setGoodsNumber(goodsNumber);
                //获取用户名称
                this.shopCart.setUserName(user.getUserName());
                //添加到购物车
                this.purchaseGoodsMapper.addCartGoods(shopCart);
                System.out.println("购买成功！");
                break;
            }

            System.out.println("是否继续添加？（y/n）");
        }while (sc.next().equals("y"));
        back(user);
    }

    //购物车界面
    public void shoppingCart(User user){
        shoppingCart shoppingCart = new shoppingCart();
        for (int i = 0; i <1 ; i++) {
            System.out.println("1、查看购物车商品  \t 2、修改商品数量 \t 3、删除购物车商品 \t 4、清空购物车 \t 0、返回上一级");
            String num = sc.next();
            if (num.matches("[0-4]")){
                switch (num){
                    case "1":
                        getAllCartGoods(user);
                        break;
                    case "2":
                        updateCartGoodsNumber(user);
                        break;
                    case "3":
                        deleteCartGoods(user);
                        break;
                    case "4":
                        deleteAllGoods(user);
                        break;
                    case "0":
                        shoppingCart.shoppingGoods(user);
                        break;
                }
            }else {
                System.out.println("0·4选择相应功能");
                i--;
            }
        }


    }

    //返回购物车界面的方法
    public void back(User user){
        System.out.println("返回上一级请按“0”");
        if(sc.nextInt() == 0){
            shoppingCart(user);
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
