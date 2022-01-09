package programmer.lp.mybatis_search;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import programmer.lp.mybatis_search.bean.Experience;
import programmer.lp.mybatis_search.bean.Skill;
import programmer.lp.mybatis_search.util.Mybaties;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main4(String[] args) {
        try (SqlSession sqlSession = Mybaties.openSession()) {
            List<Experience> experiences = sqlSession.selectList("experience.list");
            List<Experience> experiences2 = sqlSession.selectList("experience.list3");
            for (Experience experience : experiences) {
                System.out.println(experience);
            }
        }
    }

    public static void main(String[] args) {
        try (SqlSession sqlSession = Mybaties.openSession()) {
//            PageHelper.startPage(1, 10); // 查询第1页，每页10条
            PageHelper.startPage(2, 10); // 查询第2页，每页10条
            List<Skill> lists = sqlSession.selectList("skill.list");
            for (Skill skill : lists) {
                System.out.println(skill.getId() + "____" + skill.getName());
            }
            System.out.println("------------------------------");
            lists = sqlSession.selectList("skill.list");
            for (Skill skill : lists) {
                System.out.println(skill.getId() + "____" + skill.getName());
            }
        }
    }

    public static void main3(String[] args) {
        try (SqlSession sqlSession = Mybaties.openSession()) {
            List<Experience> lists = sqlSession.selectList("experience.list");
            for (Experience experience : lists) {
                System.out.println(experience);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main2(String[] args) {
        try (SqlSession sqlSession = Mybaties.openSession()) {
            List<Map<String, Object>> lists = sqlSession.selectList("experience.list1");
            List<Experience> lists2 = sqlSession.selectList("experience.list2");
            for (Map<String, Object> map : lists) {
                System.out.println(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main1(String[] args) {
        try (SqlSession sqlSession = Mybaties.openSession()) {
            List<Experience> experiences = sqlSession.selectList("experience.list");
            for (Experience experience : experiences) {
                System.out.println(experience);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
