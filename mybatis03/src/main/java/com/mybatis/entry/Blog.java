package com.mybatis.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;




@Data
@NoArgsConstructor
@AllArgsConstructor
//设置别名 （需要在mybatis-config.xml中配置）
// @Alias("blog")
public class Blog implements Serializable {
//二级缓存需要将实体类序列化
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;

}