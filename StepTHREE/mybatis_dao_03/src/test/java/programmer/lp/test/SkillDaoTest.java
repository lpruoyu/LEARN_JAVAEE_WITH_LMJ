package programmer.lp.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import programmer.lp.bean.Skill;
import programmer.lp.dao.SkillDao;
import programmer.lp.util.MyBatises;

import java.util.List;

public class SkillDaoTest {
    @Test
    public void add() {
        try (final SqlSession session = MyBatises.openSession(true)) {
            SkillDao dao = session.getMapper(SkillDao.class);
            final Skill skill = new Skill("learn coding", 10010);
            Assert.assertTrue(dao.add(skill));
            System.out.println(skill.getId());
        }
    }

    @Test
    public void remove() {
        try (final SqlSession session = MyBatises.openSession(true)) {
            SkillDao dao = session.getMapper(SkillDao.class);
            Assert.assertTrue(dao.remove(50));
        }
    }

    @Test
    public void update() {
        try (final SqlSession session = MyBatises.openSession(true)) {
            SkillDao dao = session.getMapper(SkillDao.class);
            Skill skill = new Skill("888", 888);
            skill.setId(38);
            Assert.assertTrue(dao.update(skill));
        }
    }

    @Test
    public void get() {
        try (final SqlSession session = MyBatises.openSession()) {
            SkillDao dao = session.getMapper(SkillDao.class);
            System.out.println(dao.get(3).getName());
        }
    }

    @Test
    public void list() {
        try (final SqlSession session = MyBatises.openSession()) {
            SkillDao dao = session.getMapper(SkillDao.class);
            List<Skill> skills = dao.list();
            for (Skill skill : skills) {
                System.out.println(skill.getId() + "____" + skill.getName());
            }
        }
    }

    @Test
    public void listPage() {
        try (final SqlSession session = MyBatises.openSession()) {
            SkillDao dao = session.getMapper(SkillDao.class);
            List<Skill> skills = dao.listPage(10, 10);
            for (Skill skill : skills) {
                System.out.println(skill.getId() + "____" + skill.getName());
            }
        }
    }

}

