package com.mybatis.mapper;

import com.mybatis.entry.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.Alias;

import java.util.List;
@Alias("UserMapper")
public interface UserMapper {

    @Select("select * from user")
     List<User> getUserList();

    //修改一个用户
    @Update("update user set username=#{username},password=#{password} where id = #{id}")
    int updateUser(User user);

    //添加一个用户
    @Insert("insert into user (id,username,password) values (#{id},#{username},#{password})")
    int addUser(User user);

//    @Delete("delete from user where id=#{id}")

    void delUser(Integer id);
}
