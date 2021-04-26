import com.mybatis.entry.Teacher;
import com.mybatis.mapper.TeacherMapper;
import com.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @ClassName Test01
 * @Date 2021/4/26 17:56
 * @Author 李明杰
 * @Description TODO
 */

public class Test01 {
    @Test
    public void testGetTeacher(){

        SqlSession session = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());
    }
}
