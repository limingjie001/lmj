package com.lmj.dao;

import com.lmj.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;


import java.util.List;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserMapper {
    public List<User> selectUser() {
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
