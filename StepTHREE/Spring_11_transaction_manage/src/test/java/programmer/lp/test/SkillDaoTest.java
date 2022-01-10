package programmer.lp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import programmer.lp.domain.Skill;
import programmer.lp.service.SkillService;

import java.util.List;

public class SkillDaoTest {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    SkillService skillService = applicationContext.getBean("skillService", SkillService.class);


    @Test
    public void update() {
        final Skill skill = new Skill("Spring", 1);
        skill.setId(3);
        skillService.update(skill);
    }

    @Test
    public void list() {
        List<Skill> list = skillService.list();
        System.out.println(list);
    }

    @Test
    public void test()  throws Exception{
        skillService.test();
    }

}