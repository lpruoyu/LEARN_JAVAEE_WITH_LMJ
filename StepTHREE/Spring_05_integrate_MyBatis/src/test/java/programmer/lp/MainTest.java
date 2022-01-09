package programmer.lp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import programmer.lp.dao.SkillDao;
import programmer.lp.domain.Skill;

import java.util.List;

public class MainTest {

    @Test
    public void save() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SkillDao skillDao = ctx.getBean("skillDao", SkillDao.class);
        System.out.println(skillDao.save(new Skill("Java", 20)));
    }

    @Test
    public void get() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SkillDao skillDao = ctx.getBean("skillDao", SkillDao.class);
        Skill skill = skillDao.get(3);
        System.out.println(skill);
    }

    @Test
    public void list() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SkillDao skillDao = ctx.getBean("skillDao", SkillDao.class);
        List<Skill> skills = skillDao.list();
        System.out.println(skills);
    }

}
