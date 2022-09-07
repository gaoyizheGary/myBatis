package com.gaoyizhe.mybatis.test;

import com.gaoyizhe.mybatis.mapper.UserMapper;
import com.gaoyizhe.mybatis.pojo.User;
import com.gaoyizhe.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testInsertUser() throws IOException {
        //获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sql的会话对象SqlSession，是mybatis提供的操作数据库的对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取Mapper代理实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        int result = mapper.insertUser();
//        int result = sqlSession.insert("com.gaoyizhe.mybatis.mapper.UserMapper.insertUser");
        System.out.println(result);
//        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testUpdateUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取Mapper代理实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
    }

    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取Mapper代理实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
    }
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取Mapper代理实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
    }
    @Test
    public void testGetALLUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取Mapper代理实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getALLUser();
        user.forEach(System.out::println);
        System.out.println("啊啊啊啊啊");
    }
}
