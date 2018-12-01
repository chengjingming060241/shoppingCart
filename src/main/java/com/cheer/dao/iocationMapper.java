package com.cheer.dao;

import com.cheer.model.Iocation;

public interface iocationMapper {
    //查询用户所有地址
    void getIocation(Integer userId);

    //查询用户单个地址
    void getAnyIocation(Integer iocationId);

    //修改用户地址
    void updateIocation(Iocation iocation);

    //添加用户地址
    void addIocation(Iocation iocation);

    //删除用户地址
    void deleteIocation(Integer iocationId);

}
