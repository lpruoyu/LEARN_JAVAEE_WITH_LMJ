package programmer.lp.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import programmer.lp.bean.Skill;
import programmer.lp.dao.SkillDao;
import programmer.lp.util.MyBatises;

import java.util.ArrayList;
import java.util.List;

public class SkillDaoTest {

    @Test
    public void adds() {
        try (final SqlSession session = MyBatises.openSession(true)) {
            SkillDao dao = session.getMapper(SkillDao.class);
            List<Skill> lists = new ArrayList<>();
            Skill skill = new Skill("learn 1", 1001); lists.add(skill);
            skill = new Skill("learn 2", 1002); lists.add(skill);
            skill = new Skill(null, null); lists.add(skill);
            skill = new Skill("learn 3", 1003); lists.add(skill);
            skill = new Skill("learn 4", 1004); lists.add(skill);
            Assert.assertTrue(dao.adds(lists));
            for (Skill s : lists) {
                System.out.println(s.getId());
            }
        }
    }

    @Test
    public void add() {
        try (final SqlSession session = MyBatises.openSession(true)) {
            SkillDao dao = session.getMapper(SkillDao.class);
            final Skill skill = new Skill("learn programming", 10086);
            Assert.assertTrue(dao.add(skill));
            System.out.println(skill.getId());
        }
    }

    @Test
    public void remove() {
        try (final SqlSession session = MyBatises.openSession(true)) {
            SkillDao dao = session.getMapper(SkillDao.class);
            Assert.assertTrue(dao.remove(2));
        }
    }

    @Test
    public void update() {
        try (final SqlSession session = MyBatises.openSession(true)) {
            SkillDao dao = session.getMapper(SkillDao.class);
            Skill skill = new Skill("666", 666);
            skill.setId(30);
            Assert.assertTrue(dao.update(skill));
        }
    }

    @Test
    public void get() {
        try (final SqlSession session = MyBatises.openSession()) {
            SkillDao dao = session.getMapper(SkillDao.class);
            System.out.println(dao.get(1).getName());
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

}

