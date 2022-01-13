package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmer.lp.configuration.ApplicationConfiguration;
import programmer.lp.service.SkillService;

public class MainTest {

    @Test
    public void test() {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        SkillService skillService = ctx.getBean("skillService", SkillService.class);
        skillService.test();
    }

}
