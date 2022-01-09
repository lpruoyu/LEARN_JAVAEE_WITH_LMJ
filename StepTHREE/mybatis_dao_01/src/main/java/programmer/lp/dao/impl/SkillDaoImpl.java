package programmer.lp.dao.impl;

import org.apache.ibatis.session.SqlSession;
import programmer.lp.bean.Skill;
import programmer.lp.dao.SkillDao;
import programmer.lp.util.MyBatises;

import java.util.List;

public class SkillDaoImpl implements SkillDao {
    @Override
    public boolean add(Skill skill) {
        try (SqlSession session = MyBatises.openSession(true)) {
            return session.insert("skill.add", skill) > 0;
        }
    }

    @Override
    public boolean remove(Integer id) {
        try (SqlSession session = MyBatises.openSession(true)) {
            return session.delete("skill.remove", id) > 0;
        }
    }

    @Override
    public boolean update(Skill skill) {
        try (SqlSession session = MyBatises.openSession(true)) {
            return session.update("skill.update", skill) > 0;
        }
    }

    @Override
    public Skill get(Integer id) {
        try (SqlSession session = MyBatises.openSession()) {
            return session.selectOne("skill.get", id);
        }
    }

    @Override
    public List<Skill> list() {
        try (SqlSession session = MyBatises.openSession()) {
            return session.selectList("skill.list");
        }
    }
}
