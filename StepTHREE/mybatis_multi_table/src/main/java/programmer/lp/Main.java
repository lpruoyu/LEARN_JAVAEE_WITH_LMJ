package programmer.lp;

import org.apache.ibatis.session.SqlSession;
import programmer.lp.bean.Job;
import programmer.lp.bean.Person;
import programmer.lp.util.MyBatises;

import java.util.List;

public class Main {

    public static void main() {
        try (SqlSession session = MyBatises.openSession()) {
            List<Job> lists = session.selectList("job.list");
            Job job = session.selectOne("job.get", 1);
            System.out.println(lists);
            System.out.println(job);
        }
    }

    public static void main(String[] args) {
        try (SqlSession session = MyBatises.openSession()) {
            List<Person> lists = session.selectList("person.list");
            Person person = session.selectOne("person.get", 3);
            System.out.println(person.getName());
        }
    }

}