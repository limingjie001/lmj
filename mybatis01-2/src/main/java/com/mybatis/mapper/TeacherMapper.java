package com.mybatis.mapper;

import com.mybatis.entry.Teacher;

public interface TeacherMapper {
    //获取指定老师，及老师下的所有学生
    public Teacher getTeacher(int id);
}
