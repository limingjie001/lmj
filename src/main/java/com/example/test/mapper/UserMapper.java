package com.example.test.mapper;

import com.example.test.bean.UserBean;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    UserBean getInfo(String name,String password);

}
