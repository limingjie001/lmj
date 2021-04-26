package com.mybatis.entry;

import lombok.Data;

import java.util.List;

/**
 * @ClassName Teacher
 * @Date 2021/4/26 17:50
 * @Author 李明杰
 * @Description TODO
 */

@Data
public class Teacher {
    private int id;
    private String name;
    //一个老师多个学生
    private List<Student> students;
}