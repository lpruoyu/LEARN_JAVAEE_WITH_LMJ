package programmer.lp;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmer.lp.domain.CarServiceImpl;

public class MainTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext("programmer.lp");
        final CarServiceImpl carService = ctx.getBean("carService", CarServiceImpl.class);
        carService.mineMethod();
        ctx.close();
    }

}
