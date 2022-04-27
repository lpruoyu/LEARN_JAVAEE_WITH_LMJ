package programmer.lp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.dao.SkillDao;
import programmer.lp.domain.Skill;
import programmer.lp.service.SkillService;

import java.util.List;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillDao dao;

    @Override
    public boolean save(Skill skill) {
        System.out.println(skill.getId());
        Integer id = skill.getId();
        if (id == null || id < 1) {
            return dao.save(skill);
        }
        return dao.update(skill);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Skill> list() {
        return dao.list();
    }

    @Override
    @Transactional(readOnly = true)
    public Skill get(Integer id) {
        return dao.get(id);
    }

    @Override
    public boolean remove(Integer id) {
        return dao.remove(id);
    }
}
