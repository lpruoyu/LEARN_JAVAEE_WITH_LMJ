package programmer.lp.test;

import org.junit.Assert;
import org.junit.Test;
import programmer.lp.bean.Skill;
import programmer.lp.dao.SkillDao;
import programmer.lp.dao.impl.SkillDaoImpl;

import java.util.List;

public class SkillDaoTest {

    @Test
    public void add() {
        SkillDao dao = new SkillDaoImpl();
        final Skill skill = new Skill("learn programming", 10086);
        Assert.assertTrue(dao.add(skill));
        System.out.println(skill.getId());
    }

    @Test
    public void remove() {
        SkillDao dao = new SkillDaoImpl();
        Assert.assertTrue(dao.remove(41));
    }

    @Test
    public void update() {
        SkillDao dao = new SkillDaoImpl();
        Skill skill = new Skill("666", 666);
        skill.setId(42);
        Assert.assertTrue(dao.update(skill));
    }

    @Test
    public void get() {
        SkillDao dao = new SkillDaoImpl();
        System.out.println(dao.get(1).getName());
    }

    @Test
    public void list() {
        SkillDao dao = new SkillDaoImpl();
        List<Skill> skills = dao.list();
        for (Skill skill : skills) {
            System.out.println(skill.getId() + "____" + skill.getName());
        }
    }

}
