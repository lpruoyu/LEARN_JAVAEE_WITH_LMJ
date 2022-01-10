package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import programmer.lp.service.SkillService;
import programmer.lp.service.UserService;
import programmer.lp.service.impl.UserServiceImpl;

public class MainTest {

    @Test
    public void userService() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        userService.login("xx", "yz");
        userService.register("xxx", "yyy", "zzz");

    }


    @Test
    public void processorTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SkillService skillService = ctx.getBean("skillService", SkillService.class);
        UserService userService = ctx.getBean("userService", UserService.class);

//        skillService.toString();
        skillService.delete(10);
//        userService.login("xx", "yz");
//        skillService.delete(10);
// 使用JDK/CGLib生成的代理对象，会代理目标对象的所有方法
//        userService.toString();
//        skillService.toString();
//        userService.hashCode();
//        skillService.hashCode();
    }

    @Test
    public void skillService() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SkillService skillService = ctx.getBean("skillService", SkillService.class);
        skillService.delete(10);
    }

    @Test
    public void userService1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 目标对象
        UserService target = ctx.getBean("userService", UserServiceImpl.class);
        target.login("xxx", "xyz");
        // 代理对象
//        UserService userService = (UserService) Proxy.newProxyInstance(
//                this.getClass().getClassLoader(),
//                target.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    // 代理方法
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("proxy-------------------before");
//
//                        // 调用目标对象的目标方法
//                        Object result = method.invoke(target, args);
//
//                        System.out.println("proxy----------------------end");
//                        return result;
//                    }
//                });
//        userService.login("lpruoyu", "123456");
//        userService.register("lpruoyu", "123456", "123");
//        System.out.println(login ? "登录成功" : "登录失败");
//        System.out.println(register ? "注册成功" : "注册失败");
    }

}