package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        final String[] beanNames = ctx.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.err.println(beanName);
        }
    }

}
