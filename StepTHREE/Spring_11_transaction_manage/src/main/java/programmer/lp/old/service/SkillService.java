package programmer.lp.old.service;

import programmer.lp.domain.Skill;

import java.util.List;

public interface SkillService {
    boolean add(Skill skill);
    boolean adds(List<Skill> skills);
    boolean remove(Integer id);
    boolean update(Skill skill);
    Skill get(Integer id);
    List<Skill> list();

    void test() throws Exception;
    void test1(Skill skill);
    Skill test0();

}
