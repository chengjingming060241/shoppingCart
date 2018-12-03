package com.cheer.dao;

import com.cheer.model.User;
import org.apache.ibatis.annotations.Param;


import java.util.Map;

public interface userMapper {

    //获取用户名
    String getUserName(String userName);

    //获取密码
    String getPassWord(String userName);

    //获取用户名、密码
    User getUserNamePassWord(@Param("userName") String userName ,@Param("passWord") String passWord);

    //
    int getCountUserNamePassWord(@Param("userName") String userName ,@Param("passWord") String passWord);

    //修改
    void updatePassWord(@Param("oldPassWord") String oldPassWord, @Param("newPassWord") String newPassWord);

    //注册用户
    void addUser(User user);

    //获取用户金额
    double getMoney(String userName);

    //添加余额的方法
    void updateMoney(User user);


}
