package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import programmer.lp.domain.Human;
import programmer.lp.domain.Person;
import programmer.lp.obj.ConnectionFactoryBean;

import java.sql.Connection;

public class MainTest {

    @Test
    public void testHuman() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Human baby = ctx.getBean("baby", Human.class);
        System.out.println(baby);
    }


    @Test
    public void testConnection() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Connection connection = ctx.getBean("connection", Connection.class);
        ConnectionFactoryBean connectionFactoryBean = ctx.getBean("&connection", ConnectionFactoryBean.class);
        System.out.println(connection);
        System.out.println(connectionFactoryBean);
    }

    @Test
    public void testPerson() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = ctx.getBean("personx", Person.class);
        System.out.println(person);
    }

}
