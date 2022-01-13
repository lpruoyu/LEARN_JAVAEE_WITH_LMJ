package programmer.lp.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import programmer.lp.domain.Skill;

import java.util.List;

//@Component("daoSkill")
public interface SkillDao {

    @Select("SELECT id, name, level, created_time FROM skill")
    List<Skill> list();

    @Insert("INSERT INTO skill(name, level) VALUES (#{name}, #{level})")
    boolean add(Skill skill);

}
