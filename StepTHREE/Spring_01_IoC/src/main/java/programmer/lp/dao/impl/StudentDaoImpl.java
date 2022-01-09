package programmer.lp.dao.impl;

import programmer.lp.dao.StudentDao;

public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean remove(Integer id) {
        System.out.println("StudentDaoImpl-remove : " + id);
        return true;
    }

}
