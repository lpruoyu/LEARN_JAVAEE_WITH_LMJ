package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import programmer.lp.old.service.SkillService;
import programmer.lp.old.service.UserService;
import programmer.lp.old.service.impl.UserServiceImpl;
import programmer.lp.old.service.proxy.UserServiceProxy;

public class MainTest {

    @Test
    public void skillService() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SkillService skillService = ctx.getBean("skillService", SkillService.class);
        skillService.delete(10);
    }

    @Test
    public void userServiceTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        if (userService.login("lpruoyu", "123456")) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("登录失败！");
        }
    }

    @Test
    public void userService() {
        UserService userService = new UserServiceProxy(new UserServiceImpl());
        if (userService.login("lpruoyu", "123456")) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("登录失败！");
        }
    }

}