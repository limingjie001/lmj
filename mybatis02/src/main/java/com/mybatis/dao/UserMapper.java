package com.mybatis.dao;

import com.mybatis.entry.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
     List<User> getUserList();

    //修改一个用户
    @Update("update user set username=#{username},password=#{password} where id = #{id}")
    int updateUser(User user);

    //添加一个用户
    @Insert("insert into user (id,username,password) values (#{id},#{username},#{password})")
    int addUser(User user);
}
