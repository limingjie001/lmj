package com.mybatis.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data

public class Student {
    private int id;
    private String name;
    //多个学生可以是同一个老师，即多对一
    private Teacher teacher;
}