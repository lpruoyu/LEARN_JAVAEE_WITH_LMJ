package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import programmer.lp.domain.BeanConfiguration;
import programmer.lp.domain.BeanConfiguration2;
import programmer.lp.domain.Dog;

public class MainTest {

    //    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml",
                "applicationContext-tx.xml",
                "applicationContext-mybatis.xml");
        System.out.println(ctx.getBean("dog"));
//        ApplicationContext ctxAll = new ClassPathXmlApplicationContext("classpath*:applicationContext*.xml");
//        System.out.println(ctxAll.getBean("dog"));
    }

    @Test
    public void test5() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Dog.class);
        System.out.println(ctx.getBean("dog"));
        System.out.println(ctx.getBean("domain1.dog1"));
        System.out.println(ctx.getBean("domain1.dog2"));
        System.out.println(ctx.getBean("domain2.dog1"));
        System.out.println(ctx.getBean("domain2.dog2"));
    }

    @Test
    public void test4() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        System.out.println(ctx.getBean("food"));
        System.out.println(ctx.getBean("human"));
        System.out.println(ctx.getBean("dog"));
        System.out.println(ctx.getBean("person"));
    }

    @Test
    public void test3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("programmer.lp", "programmer.lpruoyu");
        System.out.println(ctx.getBean("food"));
        System.out.println(ctx.getBean("human"));
        System.out.println(ctx.getBean("dog"));
        System.out.println(ctx.getBean("person"));
    }

    @Test
    public void test2() {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(Dog.class);
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class, BeanConfiguration2.class);
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration2.class);
        System.out.println(ctx.getBean("food"));
        System.out.println(ctx.getBean("human"));

//        ApplicationContext ctx = new AnnotationConfigApplicationContext(Dog.class, Person.class);
        // 只能使用Dog和Person
//        System.out.println(ctx.getBean("dog"));
//        System.out.println(ctx.getBean("person"));
    }

}
