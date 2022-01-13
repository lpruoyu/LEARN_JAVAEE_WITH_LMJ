package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import programmer.lp.configuration.ApplicationConfiguration;
import programmer.lp.dao.SkillDao;
import programmer.lp.domain.Skill;

import java.util.List;

public class MainTest {

    @Test
    public void testXML() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SkillDao skillDao = ctx.getBean("skillDao", SkillDao.class);
        final List<Skill> list = skillDao.list();
        System.out.println(list);
    }

    @Test
    public void testAnnotation() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        SkillDao skillDao = ctx.getBean("skillDao", SkillDao.class);
        final List<Skill> list = skillDao.list();
        System.out.println(list);
    }

}
