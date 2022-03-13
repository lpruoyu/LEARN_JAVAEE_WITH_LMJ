package programmer.lp.service;

import programmer.lp.domain.Skill;

import java.util.List;

public interface SkillService {
    boolean remove(Integer id);
    boolean save(Skill skill);
    Skill get(Integer id);
    List<Skill> list();

    boolean update(Skill skill);

    boolean insert(Skill skill);
}
