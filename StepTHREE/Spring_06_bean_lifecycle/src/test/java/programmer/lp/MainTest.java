package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import programmer.lp.service.UserService;

public class MainTest {

    @Test
    public void mulitUserService() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (int i = 0; i < 3; i++) {
            UserService userService = ctx.getBean("userService", UserService.class);
            userService.login("lpruoyu", "lp_like_coding");
            System.out.println("----------------------");
        }
        ((ClassPathXmlApplicationContext) ctx).close();
    }

    @Test
    public void userService() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        userService.login("lpruoyu", "lp_like_coding");
        // 关闭容器
        // 关闭容器的方法在ClassPathXmlApplicationContext中，不在ApplicationContext
        ((ClassPathXmlApplicationContext) ctx).close();

//        System.gc();
//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(100000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
    }

}
