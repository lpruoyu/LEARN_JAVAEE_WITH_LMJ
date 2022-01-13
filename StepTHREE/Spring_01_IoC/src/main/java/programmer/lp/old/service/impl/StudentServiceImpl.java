package programmer.lp.old.service.impl;

import programmer.lp.dao.StudentDao;
import programmer.lp.dao.impl.StudentDaoImpl;
import programmer.lp.old.service.StudentService;

public class StudentServiceImpl implements StudentService {
    private StudentDao dao;
    public void setDao(StudentDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public boolean remove(Integer id) {
        return dao.remove(id);
    }
}


