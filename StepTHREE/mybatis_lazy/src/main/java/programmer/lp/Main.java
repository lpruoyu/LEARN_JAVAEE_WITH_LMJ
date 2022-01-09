package programmer.lp;

import org.apache.ibatis.session.SqlSession;
import programmer.lp.bean.Person;
import programmer.lp.util.MyBatises;

public class Main {

    public static void main(String[] args) {
        try (SqlSession session = MyBatises.openSession()) {
            Person person = session.selectOne("person.get", 2);
//            person.getIdCard().getNo();
//            person.getBankCards();
            person.getJobs();
        }
    }

}