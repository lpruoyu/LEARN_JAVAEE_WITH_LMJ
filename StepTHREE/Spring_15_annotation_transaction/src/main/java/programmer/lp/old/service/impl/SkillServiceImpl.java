package programmer.lp.old.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.dao.SkillDao;
import programmer.lp.domain.Skill;
import programmer.lp.old.service.SkillService;

import java.util.List;

@Component
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
    public boolean update(Skill skill) {
        return dao.update(skill);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Skill> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void test() throws Exception {
        dao.add(new Skill("JavaSE", 1111));
        dao.add(new Skill("JavaWEB", 2222));
        dao.add(new Skill("MyBatis", 3333));
        dao.add(new Skill("Spring", 4444));
        dao.add(new Skill("SpringMVC", 5555));
        dao.add(new Skill("SpringBoot", 6666));
        dao.add(new Skill("SpringCloud", 7777));

        throw new RuntimeException();
    }
}
