package com.cheer.shoppingCart;

import com.cheer.model.User;
import com.cheer.util.AbstractMapper;
import com.cheer.util.userMapperImpl;
import java.util.Scanner;
import java.util.UUID;

public class userRealize extends AbstractMapper {

    userMapperImpl userMapper = new userMapperImpl();
    Scanner sc = new Scanner(System.in);


    //登录的方法
    public User Login(){
        User user = null;
        for (int i = 3; i >=1 ; i--) {
            System.out.println("请输入用户名：");
            String name = sc.next();
            System.out.println("请输入密码：");
            String password = sc.next();
            if (1 == userMapper.getCountUserNamePassWord(name,password)){
                user = userMapper.getUserNamePassWord(name,password);
                System.out.println("登录成功");
                shoppingCart shoppingCart = new shoppingCart();
                shoppingCart.shoppingGoods(user);
            }else {
                System.out.println("账号密码错误，还有"+(i-1)+"次机会请重新登录！");
            }
        }
        return user;
    }

    //注册的方法
    public void addID(){
        User user = new User();
        System.out.println("请输入用户名：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        user.setUserId(UUID());
        user.setUserName(name);
        user.setPassWord(password);
        user.setUserMoney(0.00);
        userMapper.addUser(user);
        System.out.println("注册成功！");
        Login();
    }

    //修改密码的方法
    public void updatePassword(User user){
        for (int i = 3; i >=1 ; i--) {
          //  System.out.println("请输入用户名：");
          //  String name = sc.next();
            System.out.println("请输入旧密码：");
            String password = sc.next();
            if (user.getUserName().equals(userMapper.getUserName(user.getUserName()))&& password.equals(userMapper.getPassWord(user.getUserName()))){
                for (int j = 3; j >=1 ; j--) {
                    System.out.println("请输入新密码");
                    String password1 = sc.next();
                    System.out.println("请再次输入");
                    String password2 = sc.next();
                    if(password1.equals(password2)){
                        userMapper.updatePassWord(password,password2);
                        System.out.println("密码修改成功");
                        shoppingCart shoppingCart = new shoppingCart();
                        shoppingCart.shoppingGoods(user);
                        break;
                    }else {
                        System.out.println("两次输入不一致，请重新输入，还有"+(j-1)+"次机会");
                    }
                }
                break;
            }else {
                System.out.println("账号密码错误，还有"+(i-1)+"次机会请重新输入！");
            }
        }

    }

    public void updateMoney(User user){
        do {
            System.out.println("请输入充值金额");
            double money = sc.nextDouble();
            if (money<=0){
                System.out.println("充值金额最小为“1元”,是否继续充值y/n");
                continue;
            } else {
                double userMoney = this.userMapper.getMoney(user.getUserName()) + money;
                user.setUserMoney(userMoney);
                user.setUserName(user.getUserName());
                this.userMapper.updateMoney(user);
            }
            System.out.println("是否继续充值y/n");
        }while (sc.next().equals("y"));
        shoppingCart shoppingCart = new shoppingCart();
        shoppingCart.shoppingGoods(user);

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
