package com.jyyr.ssm.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    /*
    测试查询
     */
    /*@Test
    public void run1() throws IOException {
        *//*加载配置文件*//*
       InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
       //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有数据
        List<Account> all = dao.findAll();
        for(Account account : all){
            System.out.println(account);
        }

        //关闭资源
        session.close();
        in.close();

    }

    *//**
     * 测试保存
     *//*
    @Test
    public void run2() throws IOException {
        *//*加载配置文件*//*
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有数据
        dao.saveAccount(new Account(null,"zoro","14000"));
        //提交事务
        session.commit();
        //关闭资源
        session.close();
        in.close();
    }*/
}
