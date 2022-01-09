package programmer.lp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import programmer.lp.bean.Skill;
import programmer.lp.util.MyBatises;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (SqlSession session = MyBatises.openSession()) {
            List<Skill> skills = session.selectList("skill.list");
            System.err.println(skills);
        }
    }


    public static void main4(String[] args) {
        try (SqlSession session = MyBatises.openSession()) {
            Skill skill = new Skill();
            skill.setLevel(2);
            skill.setName("hhhh");
            skill.setId(1);

            Map<String, Object> map = new HashMap<>();

            map.put("name", "hhhh");
            map.put("level", 2);
            map.put("id", 1);
            session.selectList("skill.list2", skill);
            session.selectList("skill.list3", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main1(String[] args) {
        SqlSession session = null;
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            // SQL session
            session = factory.openSession();
            //映射文件（Bean-表）下配置的 namespace.id
            List<Skill> skills = session.selectList("skill.list");
            for (Skill skill : skills) {
                System.out.println(skill);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                // 关闭session不代表会关闭连接，只代表关闭session，关闭这次会话
                // 连接池会将这个连接放回池子里去
                // 连接池已经在mybatis-config.xml中配置了
                // 至于什么时候关闭连接，就看连接池是如何管理连接的了
                session.close();
            }
        }
    }

}
