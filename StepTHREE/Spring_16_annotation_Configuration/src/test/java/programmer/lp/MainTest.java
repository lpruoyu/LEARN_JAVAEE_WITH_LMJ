package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import programmer.lp.domain.Human;

public class MainTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Human human = ctx.getBean("human", Human.class);
        System.out.println(human);
    }

    @Test
    public void dogTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(ctx.getBean("dog"));
//        System.out.println(ctx.getBean("&dog"));
    }

//    @Test
//    public void testPerson() {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Dog dog = ctx.getBean("babyDog", Dog.class);
//        System.out.println(dog);
//    }

}
