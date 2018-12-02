package com.cheer.shoppingCart;

import com.cheer.model.User;
import com.cheer.util.AbstractMapper;
import com.cheer.util.userMapperImpl;

import java.util.Scanner;

public class userRealize extends AbstractMapper {

    userMapperImpl userMapper = new userMapperImpl();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        userRealize userRealize = new userRealize();
        userRealize.addID();
    }

    //登录的方法
    public void Login(){
        for (int i = 3; i >=1 ; i--) {
            System.out.println("请输入用户名：");
            String name = sc.next();
            System.out.println("请输入密码：");
            String password = sc.next();
            if (name.equals(userMapper.getUserName(name))&& password.equals(userMapper.getPassWord(name))){
                System.out.println("登录成功");
                shoppingCart shoppingCart = new shoppingCart();
                shoppingCart.shoppingGoods();
                break;

            }else {
                System.out.println("账号密码错误，还有"+(i-1)+"次机会请重新登录！");
            }
        }
    }

    //注册的方法
    public void addID(){
        User user = new User();
        System.out.println("请输入用户ID");
        int id = sc.nextInt();
        System.out.println("请输入用户名：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        user.setUserId(id);
        user.setUserName(name);
        user.setPassWord(password);
        userMapper.addUser(user);
        System.out.println("注册成功！");
        Login();
    }

    //修改密码的方法
    public void updatePassword(){
        for (int i = 3; i >=1 ; i--) {
            System.out.println("请输入用户名：");
            String name = sc.next();
            System.out.println("请输入旧密码：");
            String password = sc.next();
            if (name.equals(userMapper.getUserName(name))&& password.equals(userMapper.getPassWord(name))){
                for (int j = 3; j >=1 ; j--) {
                    System.out.println("请输入新密码");
                    String password1 = sc.next();
                    System.out.println("请再次输入");
                    String password2 = sc.next();
                    if(password1.equals(password2)){
                        userMapper.updatePassWord(password,password2);
                        System.out.println("密码修改成功");
                        shoppingCart shoppingCart = new shoppingCart();
                        shoppingCart.shoppingGoods();
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



}
