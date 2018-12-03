package com.cheer.shoppingCart;
import com.cheer.model.Goods;
import com.cheer.model.ShopCart;
import com.cheer.model.User;
import com.cheer.util.goodsMapperImpl;
import com.cheer.util.shopCartMapperImpl;
import com.cheer.util.userMapperImpl;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
/**
 * 购买商品的方法
 */
public class ShopCartRealize {
    Scanner sc = new Scanner(System.in);
    shopCartMapperImpl purchaseGoodsMapper = new shopCartMapperImpl();
    userMapperImpl userMapper = new userMapperImpl();
    ShopCart shopCart = new ShopCart();
    goodsMapperImpl goodsMapper = new goodsMapperImpl();
    orderRealoze orderRealoze = new orderRealoze();

    //查询所有购物车商品
    private void getAllCartGoods(User user){
        List<ShopCart> shopCartList =this.purchaseGoodsMapper.getAllCartGoods();
        for (ShopCart cartGoods: shopCartList) {
            System.out.println(cartGoods);
        }
        System.out.println("返回上一级请按“0”，直接购买请按“1”，添加订单请按“2”");
        switch (sc.nextInt()){
            case 1:
                pay(user);
                break;
            case 2:
                orderRealoze.addOrder(user);
            case 0:
                //返回上一级
                back(user);
                break;
        }
    }

    //修改购物车商品数量
    private void updateCartGoodsNumber(User user){
        System.out.println("请输入商品名称：");
        String goodsName = sc.next();
        System.out.println("请输入商品数量：");
        int goodsNumber = sc.nextInt();
        this.purchaseGoodsMapper.updateGoodsNumber(goodsName,goodsNumber);
        System.out.println("修改成功");
        back(user);
    }

    //删除购物车商品
    private void deleteCartGoods(User user){
        System.out.println("请输入商品名称：");
        String goodsName = sc.next();
        this.purchaseGoodsMapper.deleteGoods(goodsName);
        System.out.println("商品删除成功");
        //返回上一级
        back(user);
    }

    //清空购物车 --最后测试
    private void deleteAllGoods(User user){
        System.out.println("是否清空购物车（N/Y）");
        String delete = sc.next();
        if (delete.equals("Y")){
            this.purchaseGoodsMapper.deleteAllGoods();
        }
        //返回上一级
        back(user);
    }

    //支付的方法
    private void pay(User user){
        do {
            System.out.println("请输入需要购买的商品名称");
            String nameGoods = sc.next();
            //获取购物车信息
            ShopCart shop =this.purchaseGoodsMapper.getCartAnyGoods(nameGoods);
            if(null!= shop){
            //得到购买商品价格总和
            double pricePay = this.purchaseGoodsMapper.getPrice(nameGoods);
            //获取剩余余额
            double price = user.getUserMoney() - pricePay;
            user.setUserMoney(price);
            //修改用户金额
            this.userMapper.updateMoney(user);
            //获取商品库存量
            Goods goods =  this.goodsMapper.getAnyGoods(nameGoods);
            //获取购买数量
            ShopCart shopCart =  this.purchaseGoodsMapper.getCartAnyGoods(nameGoods);
            //得到剩余库存
            int goodsNum = goods.getGoodsNumber() - shopCart.getGoodsNumber();
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

    //购买商品的方法
    public void shopping(User user){
        System.out.println("输入需要购买商品的名称");
        String goodsName = sc.next();
        System.out.println("数量");
        int goodsNumber = sc.nextInt();
        //获取商品信息
        Goods goods = this.goodsMapper.getAnyGoods(goodsName);
        //添加ID
        int num = UUID();
        shopCart.setShopId(num);
        //添加商品名称
        shopCart.setGoodsName(goods.getGoodsName());
        //添加商品价格
        shopCart.setGoodsPrice(goods.getGoodsPrice());
        //添加商品数量
        shopCart.setGoodsNumber(goodsNumber);
        //获取用户名称
        shopCart.setUserName(user.getUserName());
        //按商品名称获取购物车商品信息
        ShopCart shopCart1 = this.purchaseGoodsMapper.getCartAnyGoods(goodsName);
        if(shopCart1 !=null){
            if(goodsName.equals(shopCart1.getGoodsName()) ){
                //购买相同商品时，修改商品数量
                int goodaName1 = goodsNumber + shopCart1.getGoodsNumber();
                this.purchaseGoodsMapper.updateGoodsNumber(shopCart1.getGoodsName(),goodaName1);
                back(user);
            }
        }else {
            //添加到购物车
            this.purchaseGoodsMapper.addCartGoods(shopCart);
            back(user);
        }

    }

    //购物车界面
    public void shoppingCart(User user){
        shoppingCart shoppingCart = new shoppingCart();
            System.out.println("1、查看购物车商品 \t 2、结算 \t 3、修改商品数量 \t 4、删除购物车商品 \t 5、清空购物车 \t 0、返回上一级");
            switch (sc.nextInt()){
                case 1:
                    getAllCartGoods(user);
                    break;
                case 2:
                    pay(user);
                    break;
                case 3:
                    updateCartGoodsNumber(user);
                    break;
                case 4:
                    deleteCartGoods(user);
                    break;
                case 5:
                    deleteAllGoods(user);
                    break;
                case 0:
                    shoppingCart.shoppingGoods(user);
                    break;
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
