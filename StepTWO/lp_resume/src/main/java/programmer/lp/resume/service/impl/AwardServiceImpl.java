package programmer.lp.resume.service.impl;

import programmer.lp.resume.base.BaseDao;
import programmer.lp.resume.base.BaseServiceImpl;
import programmer.lp.resume.bean.Award;
import programmer.lp.resume.dao.impl.AwardDaoImpl;
import programmer.lp.resume.service.AwardService;

public class AwardServiceImpl extends BaseServiceImpl<Award> implements AwardService {

    @Override
    protected BaseDao<Award> dao() {
        return new AwardDaoImpl();
    }

}
