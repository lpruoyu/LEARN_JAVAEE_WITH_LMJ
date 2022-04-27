package programmer.lp.dao;

import org.apache.ibatis.annotations.Select;
import programmer.lp.domain.Skill;

import java.util.List;

public interface SkillDao {
    boolean save(Skill skill);
    boolean update(Skill skill);
    boolean remove(Integer id);
    @Select("SELECT * FROM skill")
    List<Skill> list();
    @Select("SELECT * FROM skill WHERE id = #{id}")
    Skill get(Integer id);
}
