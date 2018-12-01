package com.cheer.util;

import com.cheer.dao.userMapper;
import com.cheer.model.User;

import java.util.List;
import java.util.Map;

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
    public Map<String, Object> getUserNamePassWord(String userName) {
        super.Before();
        Map<String,Object>getUserNamePassWord = this.userMapper.getUserNamePassWord(userName);
        super.After();
        return getUserNamePassWord;
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
}
