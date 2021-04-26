import com.mybatis.entry.Student;
import com.mybatis.mapper.StudentMapper;
import com.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test01 {
    @Test
    public void testGetStudents() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudents();

        for (Student student : students) {
            System.out.println(
                    "学生名:" + student.getName()
                            + "\t老师:" + student.getTeacher().getName());
        }

    }
        @Test
        public void testGetStudents2(){
            SqlSession session = MyBatisUtils.getSqlSession();
            StudentMapper mapper = session.getMapper(StudentMapper.class);

            List<Student> students = mapper.getStudents2();

            for (Student student : students){
                System.out.println(
                        "学生名:"+ student.getName()
                                +"\t老师:"+student.getTeacher().getName());
            }
        }
}
