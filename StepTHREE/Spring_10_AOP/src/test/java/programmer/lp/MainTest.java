package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import programmer.lp.old.service.SkillService;
import programmer.lp.old.service.UserService;

public class MainTest {
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        SkillService skillService = ctx.getBean("skillService", SkillService.class);
        userService.login("xxxx", "yyzz");
        skillService.delete(10);
    }

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = ctx.getBean("userService", UserService.class);
        userService = ctx.getBean("userService", UserService.class);
        System.out.println(userService);
        userService = ctx.getBean("userService", UserService.class);
        System.out.println(userService);
        userService = ctx.getBean("userService", UserService.class);
        System.out.println(userService);

        userService.login("xxxx", "yyzz");
    }
}