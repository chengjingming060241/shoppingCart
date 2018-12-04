package com.cheer.util;

import com.cheer.dao.userMapper;
import com.cheer.model.User;

public class userMapperImpl extends AbstractMapper implements userMapper {


    @Override
    public String getUserName(String userName) {
        super.Before();
        String name = this.userMapper.getUserName(userName);
        super.After();
        return name;
    }

    @Override
    public String getPassWord(String userName) {
        super.Before();
        String passWord = this.userMapper.getPassWord(userName);
        super.Before();
        return passWord;
    }

    @Override
    public User getUserNamePassWord(String userName, String passWord) {
        super.Before();
        User user = this.userMapper.getUserNamePassWord(userName,passWord);
        super.After();
        return user;
    }

    @Override
    public int getCountUserNamePassWord(String userName, String passWord) {
        super.Before();
        int num = this.userMapper.getCountUserNamePassWord(userName,passWord);
        super.After();
        return num;
    }

    @Override
    public void updatePassWord(String oldPassWord,String newPassWord) {
        super.Before();
        this.userMapper.updatePassWord(oldPassWord,newPassWord);
        super.After();
    }

    @Override
    public void addUser(User user) {
        super.Before();
        this.userMapper.addUser(user);
        super.After();
    }

    @Override
    public double getMoney(String userName) {
        super.Before();
        double userMoney = this.userMapper.getMoney(userName);
        super.After();
        return userMoney;
    }

    @Override
    public void updateMoney(User user) {
        super.Before();
        this.userMapper.updateMoney(user);
        super.After();
    }
}
