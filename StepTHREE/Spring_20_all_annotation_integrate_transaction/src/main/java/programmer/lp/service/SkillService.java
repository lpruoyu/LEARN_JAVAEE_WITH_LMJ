package programmer.lp.service;

import programmer.lp.domain.Skill;

import java.util.List;

public interface SkillService {
    boolean add(Skill skill);

    List<Skill> list();

    void test();
}
