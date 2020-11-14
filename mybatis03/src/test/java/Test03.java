import com.mybatis.entry.Blog;
import com.mybatis.mapper.BlogMapper;
import com.mybatis.utils.IDUtil;
import com.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;//是不是这个包？？？

//import java.sql.Date;
import java.util.HashMap;
import java.util.List;


public class Test03 {

    @Test
    public void addInitBlog() {
        SqlSession session = MyBatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtil.genId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);
        session.commit();
        session.close();
    }

    @Test
    public void testQueryBlogIf(){
        SqlSession session = MyBatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","Spring如此简单");
//        map.put("author","狂神说");
        List<Blog> blogs = mapper.queryBlogIf(map);
        for (Blog blogs1: blogs) {
            System.out.println(blogs1);
        }


        session.close();
    }

    @Test
    public void testUpdateBlog(){
        SqlSession session = MyBatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","动态SQL");
        map.put("author","秦疆");
        //map.put("id","9d6a763f5e1347cebda43e2a32687a77");

        mapper.updateBlog(map);

//        System.out.println(map);
        session.close();
    }
}
