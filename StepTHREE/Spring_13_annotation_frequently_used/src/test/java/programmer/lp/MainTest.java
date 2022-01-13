package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        System.out.println(ctx.getBean("person"));

//        System.out.println(ctx.getBean("userService"));
//        System.out.println(ctx.getBean("userDao"));
//        System.out.println(ctx.getBean("userServlet"));
    }

}
