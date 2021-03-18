import com.springAOP.method1.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void TestAop1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService=(UserService) applicationContext.getBean("userService");
        userService.search();
    }

}
