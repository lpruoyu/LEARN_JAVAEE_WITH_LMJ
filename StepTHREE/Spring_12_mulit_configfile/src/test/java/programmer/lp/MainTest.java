package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {


    @Test
    public void test() {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(
//                "applicationContext.xml",
//                "applicationContext-tx.xml",
//                "applicationContext-mybatis.xml"
//        );
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath*:applicationContext*.xml"
        );

//        ApplicationContext ctx = new ClassPathXmlApplicationContext(
//                "applicationContext.xml"
//        );
        System.out.println(ctx.getBean("dog"));
        System.out.println(ctx.getBean("wolf"));
        System.out.println(ctx.getBean("tiger"));
    }


}
