package com.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    /*
    1、SqlSessionFactoryBuilder 的作用在于创建 SqlSessionFactory，
    创建成功后 就失去了作用
    2、SqlSessionFactory 相当于数据库连接池，所以它占据着数据库的连接资源。
    3、SqlSession 就相当于一个数据库连接（Connection 对象），
    你可以在一个事务里面执行多条 SQL，然后通过它的 commit、rollback 等方法，提交或者回滚事务。
    */
    private static SqlSessionFactory sqlSessionFactory;


    static {


        try {
            String resource = "mybatis-config.xml";

            InputStream inputStream = Resources.getResourceAsStream(resource);
           sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static SqlSession getSqlSession(){
//        return  sqlSessionFactory.openSession();
//        设置为true，自动提交
        return  sqlSessionFactory.openSession(true);


    }
}
