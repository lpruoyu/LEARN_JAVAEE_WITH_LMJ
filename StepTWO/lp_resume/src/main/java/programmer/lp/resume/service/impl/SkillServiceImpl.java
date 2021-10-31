package programmer.lp.resume.service.impl;

import programmer.lp.resume.base.BaseDao;
import programmer.lp.resume.base.BaseServiceImpl;
import programmer.lp.resume.bean.Skill;
import programmer.lp.resume.dao.impl.SkillDaoImpl;
import programmer.lp.resume.service.SkillService;

public class SkillServiceImpl extends BaseServiceImpl<Skill> implements SkillService {

    @Override
    protected BaseDao<Skill> dao() {
        return new SkillDaoImpl();
    }

}
