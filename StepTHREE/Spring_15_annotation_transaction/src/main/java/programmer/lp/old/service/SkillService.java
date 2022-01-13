package programmer.lp.old.service;

import programmer.lp.domain.Skill;

import java.util.List;

public interface SkillService {
    boolean add(Skill skill);
    boolean update(Skill skill);
    List<Skill> list();

    void test() throws Exception;
}
