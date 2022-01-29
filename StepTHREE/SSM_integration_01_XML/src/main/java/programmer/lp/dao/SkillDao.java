package programmer.lp.dao;

import org.apache.ibatis.annotations.Select;
import programmer.lp.domain.Skill;

import java.util.List;

public interface SkillDao {
    boolean insert(Skill skill);
    boolean delete(Integer id);
    boolean update(Skill skill);
    @Select("SELECT id, created_time, name, level FROM skill WHERE id = #{id}")
    Skill get(Integer id);
    @Select("SELECT id, created_time, name, level FROM skill")
    List<Skill> list();
}
