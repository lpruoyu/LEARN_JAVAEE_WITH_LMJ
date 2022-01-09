package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import programmer.lp.servlet.StudentServlet;

public class MainTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentServlet studentServlet = applicationContext.getBean("studentServlet", StudentServlet.class);
        studentServlet.service();
    }

}








