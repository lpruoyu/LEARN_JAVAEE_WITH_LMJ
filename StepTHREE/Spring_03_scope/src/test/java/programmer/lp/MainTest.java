package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import programmer.lp.domain.Person;
import programmer.lp.domain.TestUsername;

public class MainTest {

    @Test
    public void test2() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person1 = ctx.getBean("person1", Person.class);
        Person person2 = ctx.getBean("person2", Person.class);
        System.out.println(person2 == person1);
    }

    @Test
    public void testUsername() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        TestUsername testUsername = ctx.getBean("testUsername", TestUsername.class);
        System.out.println(testUsername);
    }

    @Test
    public void test() {
        ApplicationContext ctx1 =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person0 = ctx1.getBean("person", Person.class);
        Person person1 = ctx1.getBean("person", Person.class);

        ApplicationContext ctx2 =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person2 = ctx2.getBean("person", Person.class);
        Person person3 = ctx2.getBean("person", Person.class);

        System.out.println(person0 == person2); // false

        System.out.println(person0 == person1); // true
        System.out.println(person2 == person3); // true
    }

    @Test
    public void testPerson1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person1 = ctx.getBean("person", Person.class);
        Person person2 = ctx.getBean("person", Person.class);
        System.out.println(person1 == person2); // true
    }

}
