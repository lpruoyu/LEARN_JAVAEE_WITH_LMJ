package programmer.lp.resume.service.impl;

import programmer.lp.resume.base.BaseDao;
import programmer.lp.resume.base.BaseServiceImpl;
import programmer.lp.resume.bean.Company;
import programmer.lp.resume.dao.impl.CompanyDaoImpl;
import programmer.lp.resume.service.CompanyService;

public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService {

    @Override
    protected BaseDao<Company> dao() {
        return new CompanyDaoImpl();
    }

}
