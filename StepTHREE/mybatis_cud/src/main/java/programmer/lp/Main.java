package programmer.lp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (SqlSession session = MyBatises.openSession()) {
            List<Company> lists = session.selectList("company.list3");
            for (Company company : lists) {
                System.out.println(company);
            }
        }
    }

    public static void main13(String[] args) {
        try (SqlSession session = MyBatises.openSession()) {
            List<Skill> lists = new ArrayList<>();
            lists.add(new Skill("Java11111", 11111));
            lists.add(new Skill("Java11112", 11112));
            lists.add(new Skill("Java11113", 11113));
            lists.add(new Skill("Java11114", 11114));
            session.insert("skill.batchInsert", lists);
            session.commit();
            for (Skill skill : lists) {
                System.out.println(skill.getId());
            }
        }
    }

    public static void main12(String[] args) {
        try (SqlSession session = MyBatises.openSession()) {
            Skill[] skills = {
                    new Skill("Java11", 110),
                    new Skill("Java12", 120),
                    new Skill("Java13", 130),
                    new Skill("Java14", 140)
            };
            session.insert("skill.batchInsert", skills);
            session.commit();
        }
    }

    public static void main11(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "%J%");
        map.put("level", 20);
        try (SqlSession session = MyBatises.openSession()) {
            final List<Skill> skills1 = session.selectList("skill_temp.select1", "%j%");
            final List<Skill> skills2 = session.selectList("skill_temp.select2", 2000);
            final List<Skill> skills3 = session.selectList("skill_temp.select3", map);
            System.out.println(skills1);
            System.out.println(skills2);
            System.out.println(skills3);
        }
    }


    public static void main10(String[] args) {
        try (SqlSession session = MyBatises.openSession()) {
            final List<Skill> skills1 = session.selectList("skill_temp.select1");
            final List<Skill> skills2 = session.selectList("skill_temp.select2");
            final List<Skill> skills3 = session.selectList("skill_temp.select3");
            System.out.println(skills1);
            System.out.println(skills2);
            System.out.println(skills3);

//            System.out.println(Skill.class.getName());
//            System.out.println(Skill.class.getSimpleName());

        }
    }

    public static void main9(String[] args) {
        try (SqlSession session = MyBatises.openSession()) {
            List<Integer> lists = new ArrayList<>();
            lists.add(20);
            lists.add(21);
            lists.add(22);
            lists.add(23);
            session.delete("skill.batchDelete", lists);
            session.commit();
        }
    }

    public static void main8(String[] args) {
        try (SqlSession session = MyBatises.openSession()) {
            List<Skill> lists = new ArrayList<>();
            lists.add(new Skill("Java1", 10));
            lists.add(new Skill("Java2", 20));
            lists.add(new Skill("Java3", 30));
            lists.add(new Skill("Java4", 40));
            session.insert("skill.batchInsert", lists);
            session.commit();
        }
    }

    public static void main7(String[] args) {
        try (SqlSession session = MyBatises.openSession()) {
            Map<String, Object> map = new HashMap<>();
//            map.put("id", 5);
            map.put("name", "%yy%");
//            map.put("level", 2000);
            List<Skill> lists = session.selectList("skill.dynamicSQL", map);
            System.out.println(lists);
        }
    }

    public static void main6(String[] args) {
        try (SqlSession session = MyBatises.openSession()) {
            session.delete("skill.delete", 15);
            session.commit();
        }
    }

    public static void main5(String[] args) {
        try (SqlSession session = MyBatises.openSession()) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", 14);
            map.put("name", "PythonPython");
            map.put("level", 2222);
            session.update("skill.update2", map);
            session.commit();
        }
    }

    public static void main4(String[] args) {
        try (SqlSession session = MyBatises.openSession()) {
            Skill skill = new Skill();
            skill.setId(14);
            skill.setLevel(888);
            skill.setName("PHP");
            session.update("skill.update", skill);
            session.commit();
        }
    }

    public static void main3(String[] args) {
        try (final SqlSession session = MyBatises.openSession(true)) {
            Skill skill = new Skill("abcd", 1111);
            session.insert("skill.insert", skill);
            // 获取到主键ID以供后续使用
            System.out.println(skill.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main2(String[] args) {
        try (final SqlSession session = MyBatises.openSession()) {
            Skill skill = new Skill();

            skill.setName("XXXX");
            skill.setLevel(1111);
            session.insert("skill.insert", skill);
            session.rollback();

            skill.setName("YYYY");
            skill.setLevel(2222);
            session.insert("skill.insert", skill);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main1(String[] args) {
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
             SqlSession session = new SqlSessionFactoryBuilder().build(reader).openSession()
        ) {
            List<Skill> lists = session.selectList("skill.list");
            System.out.println(lists);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
