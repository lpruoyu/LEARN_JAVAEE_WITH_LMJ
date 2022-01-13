package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmer.lp.config.ApplicationConfiguration;
import programmer.lp.learn.service.UserService;

public class MainTest {

    @Test
    public void test1() {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        final UserService userService = ctx.getBean("userService", UserService.class);
        userService.test1();
        userService.test2();
    }

}
