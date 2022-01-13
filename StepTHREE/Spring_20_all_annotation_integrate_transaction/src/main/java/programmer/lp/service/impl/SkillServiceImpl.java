package programmer.lp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.dao.SkillDao;
import programmer.lp.domain.Skill;
import programmer.lp.service.SkillService;

import java.util.List;

@Component("skillService")
public class SkillServiceImpl implements SkillService {

    private SkillDao dao;

    @Autowired
    public void setDao(SkillDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean add(Skill skill) {
        return dao.add(skill);
    }

    @Override
    public List<Skill> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void test() {
        dao.add(new Skill("xx", 11));
        dao.add(new Skill("yy", 22));
        dao.add(new Skill("zz", 33));
        System.out.println(1 / 0);
    }

}
