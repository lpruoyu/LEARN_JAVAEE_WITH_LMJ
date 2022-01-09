package programmer.lp.mybatis_cache;

import org.apache.ibatis.session.SqlSession;
import programmer.lp.mybatis_cache.bean.Skill;
import programmer.lp.mybatis_cache.util.Mybaties;


public class Main {

    public static void main(String[] args) {
        try (SqlSession sqlSession = Mybaties.openSession()) {
            Skill skill = sqlSession.selectOne("skill.get", 1);
            System.err.println(skill + "____" + skill.getName());
        }
        try (SqlSession sqlSession = Mybaties.openSession()) {
            Skill skill = sqlSession.selectOne("skill.get", 1);
            System.err.println(skill + "____" + skill.getName());
        }
        try (SqlSession sqlSession = Mybaties.openSession()) {
            Skill skill = sqlSession.selectOne("skill.get", 1);
            System.err.println(skill + "____" + skill.getName());
        }
        try (SqlSession sqlSession = Mybaties.openSession()) {
            Skill skill = sqlSession.selectOne("skill.get", 1);
            System.err.println(skill + "____" + skill.getName());
        }
    }

}