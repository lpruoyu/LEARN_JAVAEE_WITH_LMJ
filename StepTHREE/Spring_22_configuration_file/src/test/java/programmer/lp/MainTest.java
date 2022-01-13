package programmer.lp;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmer.lp.domain.Dog;

public class MainTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext("programmer.lp");
        final Dog dog = ctx.getBean("dog", Dog.class);
        System.out.println(dog);
    }

}