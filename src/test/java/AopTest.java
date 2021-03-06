import com.springAOP.method1.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    @Test
    public void TestAop1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop.xml");
        UserService userService=(UserService) applicationContext.getBean("userService");
        userService.search();
    }

    @Test
    public void TestAop2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop.xml");
        UserService userService=(UserService) applicationContext.getBean("userService");
        userService.add();
    }

    @Test
    public void TestAop3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop.xml");
        UserService userService=(UserService) applicationContext.getBean("userService");
        userService.add();
    }


}
