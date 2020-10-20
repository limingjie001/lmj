package com.mybatis.dao;

import com.mybatis.entry.User;
import com.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class UserListTest {
    @Test
    public void test(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper= sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.print(user);
        }

        sqlSession.close();
    }
}
