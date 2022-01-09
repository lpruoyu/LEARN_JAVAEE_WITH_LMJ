package programmer.lp.dao;

import programmer.lp.bean.Skill;

import java.util.List;
public interface SkillDao {
    boolean add(Skill skill);
    boolean adds(List<Skill> skill);
    boolean remove(Integer id);
    boolean update(Skill skill);
    Skill get(Integer id);
    List<Skill> list();
}

