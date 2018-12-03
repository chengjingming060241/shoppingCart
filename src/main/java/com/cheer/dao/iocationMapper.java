package com.cheer.dao;

import com.cheer.model.Iocation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface iocationMapper {
    //查询用户所有地址
    List<Iocation> getIocation(String UserName);

    //查询用户单个地址
    Iocation getAnyIocation(@Param("iocationId") Integer iocationId ,@Param("userName") String userName);

    //修改用户地址
    void updateIocation(Iocation iocation);

    //添加用户地址
    void addIocation(Iocation iocation);

    //删除用户地址
    void deleteIocation(Integer iocationId);

    //获取

}
