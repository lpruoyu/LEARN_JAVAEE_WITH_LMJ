package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import programmer.lp.domain.*;

public class MainTest {


    @Test
    public void testScreen() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Screen screen = ctx.getBean("screen", Screen.class);
        System.out.println(screen);
    }


    @Test
    public void testPhone() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Phone phone = ctx.getBean("phone", Phone.class);
        System.out.println(phone);
    }

    @Test
    public void testPerson() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Person person1 = ctx.getBean("person1", Person.class);
//        Person person2 = ctx.getBean("person2", Person.class);
//        Person person3 = ctx.getBean("person3", Person.class);
        Person person = ctx.getBean("person5", Person.class);
        System.out.println(person);
    }

    @Test
    public void testHobby() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application_context.xml");
        Hobby hobby = ctx.getBean("hobby", Hobby.class);
        System.out.println(hobby);
    }


    @Test
    public void testDog() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Dog dog = ctx.getBean("dog", Dog.class);
        System.out.println(dog);
    }


}
