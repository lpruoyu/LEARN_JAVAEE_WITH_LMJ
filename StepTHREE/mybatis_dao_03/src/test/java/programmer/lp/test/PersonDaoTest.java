package programmer.lp.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import programmer.lp.bean.Person;
import programmer.lp.dao.PersonDao;
import programmer.lp.util.MyBatises;

import java.util.List;

public class PersonDaoTest {

    @Test
    public void list() {
        try (SqlSession session = MyBatises.openSession()) {
            PersonDao dao = session.getMapper(PersonDao.class);
            List<Person> persons = dao.list();
            for (Person person : persons) {
                System.out.println(person.getId() + "____" + person.getName());
            }
        }
    }

    @Test
    public void get() {
        try (SqlSession session = MyBatises.openSession()) {
            PersonDao dao = session.getMapper(PersonDao.class);
            Person person = dao.get(1);
            System.out.println(person.getId() + "____" + person.getName());
            System.out.println(person.getBankCards());
        }
    }

}

