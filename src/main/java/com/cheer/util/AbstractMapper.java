package com.cheer.util;

import com.cheer.dao.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractMapper {
    InputStream in = null;
    SqlSession sqlSession = null;
    SqlSessionFactory sqlSessionFactory = null;
    userMapper userMapper = null;
    goodsMapper goodsMapper = null;
    iocationMapper iocationMapper = null;
    orderMapper orderMapper = null;
    ShopCartMapper shopCartMapper = null;
    public void Before(){
        try {
            //得到输入流
            in = Resources.getResourceAsStream("mybatis_config.xml");
            //得到SqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            //设置事务自动提交
            sqlSession =sqlSessionFactory.openSession(true);
            //得到用户对象
            userMapper = sqlSession.getMapper(userMapper.class);
            //得到商品对象
            goodsMapper = sqlSession.getMapper(goodsMapper.class);
            //得到地址对象
            iocationMapper = sqlSession.getMapper(iocationMapper.class);
            //得到订单对象
            orderMapper = sqlSession.getMapper(orderMapper.class);
            //获取购物车对象
            shopCartMapper = sqlSession.getMapper(ShopCartMapper.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //关闭流
    public void After(){
        //手动提交事务
        //sqlSession.commit();
        try {
            if (null != in) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (null != sqlSession) {
            sqlSession.close();
        }
    }
}
