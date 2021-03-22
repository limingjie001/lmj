package com.mybatis.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@AllArgsConstructor
@NoArgsConstructor
@Data //GET,SET,ToString，有参，无参构造

public class Teacher {
    private int id;
    private String name;
}