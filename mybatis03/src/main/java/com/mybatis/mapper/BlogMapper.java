package com.mybatis.mapper;

import com.mybatis.entry.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //新增一个博客
    int addBlog(Blog blog);
//    查询博客
    List<Blog> queryBlogIf(Map map);

    int updateBlog(Map map);

    List<Blog> queryBlogForeach(Map map);
}


