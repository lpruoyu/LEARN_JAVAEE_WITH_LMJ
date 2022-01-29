package programmer.lp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programmer.lp.dao.SkillDao;
import programmer.lp.domain.Skill;
import programmer.lp.service.SkillService;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private SkillDao dao;

    @Autowired
    public void setDao(SkillDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean remove(Integer id) {
        return dao.delete(id);
    }

    @Override
    public boolean save(Skill skill) {
        final Integer skillId = skill.getId();
        if (skillId == null || skillId < 1) {
            return dao.insert(skill);
        }
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
}
