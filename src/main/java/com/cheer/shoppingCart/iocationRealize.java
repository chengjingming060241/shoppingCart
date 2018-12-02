package com.cheer.shoppingCart;


import com.cheer.model.Iocation;
import com.cheer.util.IocationMapperImpl;

import java.util.Scanner;

public class iocationRealize {
    Scanner sc = new Scanner(System.in);
    IocationMapperImpl iocationMapper = new IocationMapperImpl();
    Iocation iocation = new Iocation();
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        IocationMapperImpl iocationMapper = new IocationMapperImpl();
//        Iocation iocation = new Iocation();
//        iocation.setIocationName("大橙子");
//        iocation.setIocationPhone("15618816266");
//        iocation.setIocation("昆山市千灯镇");
//        iocation.setUserName("chengjingming");
//        iocationMapper.addIocation(iocation);

    }
    //获取所有地址
    private void getIocation(){
        System.out.println("请输入用户名");
        iocationMapper.getIocation(sc.next());
        //返回上一级
        back();
    }

    //修改用户地址
    private void updateIocation(){
        System.out.println("请输入要修改的地址编号：");
        iocation.setIocationId(sc.nextInt());
        System.out.println("新的联系人姓名：");
        iocation.setIocationName(sc.next());
        System.out.println("新的手机号：");
        iocation.setIocationPhone(sc.next());
        System.out.println("新地址");
        iocation.setIocation(sc.next());
        iocationMapper.addIocation(iocation);
        System.out.println("修改成功");
        //返回上一级
         back();
    }
    //添加地址的方法
    private void addIocation(){
        System.out.println("输入联系人姓名：");
        iocation.setIocationName(sc.next());
        System.out.println("新的手机号：");
        iocation.setIocationPhone(sc.next());
        System.out.println("新地址");
        iocation.setIocation(sc.next());
        System.out.println("输入用户姓名：");
        iocation.setUserName(sc.next());
        iocationMapper.addIocation(iocation);
        System.out.println("添加地址成功");
        //返回上一级
        back();
    }

    private void deleteIocation(){
        System.out.println("请输入要删除的地址编号：");
        iocationMapper.deleteIocation(sc.nextInt());
        System.out.println("删除成功！");
        //返回上一级
        back();
    }
    //地址界面
    public void shoppingIocation(){
        shoppingCart shoppingCart = new shoppingCart();
        System.out.println("1、查看所有地址\t 2、修改地址 \t 3、添加新地址 \t 4、删除地址 \t 0、返回上一级");
        switch (sc.nextInt()){
            case 1:
                getIocation();
                break;
            case 2:
                updateIocation();
                break;
            case 3:
                addIocation();
                break;
            case 4:
                deleteIocation();
                break;
            case 0:
                shoppingCart.shoppingGoods();
        }
    }

    //返回地址界面的方法
    private void back(){
        System.out.println("返回上一级请按“0”");
        if(sc.nextInt() == 0){
            shoppingIocation();
        }
    }
}
