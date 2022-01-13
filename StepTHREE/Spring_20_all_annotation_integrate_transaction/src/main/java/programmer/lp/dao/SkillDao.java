package programmer.lp.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import programmer.lp.domain.Skill;

import java.util.List;

public interface SkillDao {

    @Insert("INSERT INTO skill(name, level) VALUES(#{name}, #{level})")
    boolean add(Skill skill);

    @Select("SELECT id, created_time, name, level FROM skill")
    List<Skill> list();

}
