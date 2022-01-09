package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import programmer.lp.domain.Person;

public class MainTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = ctx.getBean("person", Person.class);
        Person person1 = ctx.getBean("person1", Person.class);
        Person person2 = ctx.getBean("person2", Person.class);
        Person person3 = ctx.getBean("person3", Person.class);
        System.out.println(person);
    }

}
