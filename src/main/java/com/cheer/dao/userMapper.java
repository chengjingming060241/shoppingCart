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
    Map<String,Object> getUserNamePassWord(String userName);

    //修改
    void updatePassWord(@Param("oldPassWord") String oldPassWord, @Param("newPassWord") String newPassWord);

    //注册用户
    void addUser(User user);


}
