package programmer.lp.service.impl;

import programmer.lp.dao.SkillDao;
import programmer.lp.domain.Skill;
import programmer.lp.service.SkillService;

import java.util.List;

public class SkillServiceImpl implements SkillService {

    private SkillDao dao;

    public void setDao(SkillDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean add(Skill skill) {
        return dao.add(skill);
    }

    @Override
    public boolean adds(List<Skill> skills) {
        return dao.adds(skills);
    }

    @Override
    public boolean remove(Integer id) {
        return dao.remove(id);
    }

    @Override
    public boolean update(Skill skill) {
        return dao.update(skill);
    }

    @Override
    public Skill get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Skill> list() {
        return dao.list();
    }

    @Override
    public void test() throws Exception {
//        Skill skill = new Skill("JavaX", 9999);
//        skill.setId(69);
//        dao.update(skill);
//        System.out.println("test");

        dao.add(new Skill("JavaSE", 1111));
        dao.add(new Skill("JavaWEB", 2222));
        dao.add(new Skill("MyBatis", 3333));
        dao.add(new Skill("Spring", 4444));

//        throw new MyException("MyException");
//        throw new MyError("MyException");
//
//        dao.add(new Skill("SpringMVC", 1111));
//        dao.add(new Skill("SpringBoot", 2222));
//        dao.add(new Skill("SpringCloud", 3333));

//        System.out.println(10 / 0);

    }

    @Override
    public Skill test0() {
        Skill skill = new Skill("JavaEE", 1111);
        return dao.add(skill) ? skill : null;
    }

    @Override
    public void test1(Skill skill) {
        skill.setName("JavaEE X");
        skill.setLevel(10000);
        dao.update(skill);
    }
//
//    @Override
//    public void  test() {
//        Skill skill = test0();
//        System.out.println(10 / 0);
//        test1(skill);
//    }

}
