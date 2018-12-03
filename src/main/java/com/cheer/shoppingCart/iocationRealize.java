package com.cheer.shoppingCart;


import com.cheer.model.Iocation;
import com.cheer.model.User;
import com.cheer.util.IocationMapperImpl;
import java.util.List;
import java.util.Scanner;

public class iocationRealize {
    Scanner sc = new Scanner(System.in);
    IocationMapperImpl iocationMapper = new IocationMapperImpl();
    Iocation iocation = new Iocation();

    //获取所有地址
    private void getIocation(User user){

        List<Iocation> iocationList = iocationMapper.getIocation(user.getUserName());
        for (Iocation I:iocationList) {
            System.out.println(I);
        }
        //返回上一级
        back(user);
    }

    //修改用户地址
    private void updateIocation(User user){
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
         back(user);
    }

    //添加地址的方法
    private void addIocation(User user){
        System.out.println("输入联系人姓名：");
        iocation.setIocationName(sc.next());
        System.out.println("新的手机号：");
        iocation.setIocationPhone(sc.next());
        System.out.println("新地址");
        iocation.setIocation(sc.next());
        //System.out.println("输入用户姓名：");
        iocation.setUserName(user.getUserName());
        iocationMapper.addIocation(iocation);
        System.out.println("添加地址成功");
        //返回上一级
        back(user);
    }

    //删除地址
    private void deleteIocation(User user){
        System.out.println("请输入要删除的地址编号：");
        iocationMapper.deleteIocation(sc.nextInt());
        System.out.println("删除成功！");
        //返回上一级
        back(user);
    }

    //地址界面
    public void shoppingIocation(User user){
        shoppingCart shoppingCart = new shoppingCart();
        System.out.println("1、查看所有地址\t 2、修改地址 \t 3、添加新地址 \t 4、删除地址 \t 0、返回上一级");
        switch (sc.nextInt()){
            case 1:
                getIocation(user);
                break;
            case 2:
                updateIocation(user);
                break;
            case 3:
                addIocation(user);
                break;
            case 4:
                deleteIocation(user);
                break;
            case 0:
                shoppingCart.shoppingGoods(user);
        }
    }

    //返回地址界面的方法
    private void back(User user){
        System.out.println("返回上一级请按“0”");
        if(sc.nextInt() == 0){
            shoppingIocation(user);
        }
    }
}
