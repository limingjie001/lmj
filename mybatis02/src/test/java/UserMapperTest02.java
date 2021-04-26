import com.mybatis.mapper.UserMapper;
import com.mybatis.entry.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.mybatis.utils.MyBatisUtils;

import java.util.List;


public class UserMapperTest02 {

    @Test
    public void SelectUser(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper= sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void UpdateUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(6, "秦疆", "zxcvbn");
        mapper.updateUser(user);
        sqlSession.commit();

        List<User> userList = mapper.getUserList();
        for (User user2 : userList) {
            System.out.println(user2);
        }

        sqlSession.close();
    }

    @Test
    public void AddUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(1, "秦疆", "123456");
        mapper.addUser(user);
        sqlSession.commit();
        List<User> userList = mapper.getUserList();
        for (User user2 : userList) {
            System.out.println(user2);
        }

        sqlSession.close();
    }

    @Test
    public void DelUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int id=2;
        mapper.delUser(id);
        sqlSession.commit();
        List<User> userList = mapper.getUserList();
        for (User user2 : userList) {
            System.out.println(user2);
        }

        sqlSession.close();

    }


}
