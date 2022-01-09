package programmer.lp.service.impl;

import programmer.lp.dao.StudentDao;
import programmer.lp.factory.StudentFactory;
import programmer.lp.service.StudentService;

public class StudentServiceImpl2 implements StudentService {

    private final StudentDao dao = StudentFactory.getDao();

    @Override
    public boolean remove(Integer id) {
        System.out.println("2");
        return dao.remove(id);
    }

}
