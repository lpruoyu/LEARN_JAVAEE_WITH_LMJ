package programmer.lp.service;


import programmer.lp.domain.Skill;

import java.util.List;

public interface SkillService {
    boolean save(Skill skill);
    List<Skill> list();
    Skill get(Integer id);
    boolean remove(Integer id);
}
