package programmer.lp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
    public boolean remove(Integer id) {
        return dao.delete(id);
    }

    @Override
    public boolean save(Skill skill) {
        final Integer skillId = skill.getId();
        if (skillId == null || skillId < 1) {
            boolean result = dao.insert(skill);
            System.out.println(skill.getId());
            return result;
        }
        return dao.update(skill);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Skill get(Integer id) {
        return dao.get(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Skill> list() {
        return dao.list();
    }
}
