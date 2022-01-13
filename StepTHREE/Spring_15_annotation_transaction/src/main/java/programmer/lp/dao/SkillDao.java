package programmer.lp.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import programmer.lp.domain.Skill;

import java.util.List;

public interface SkillDao {
    @Insert("INSERT INTO skill(name, level) VALUES(#{name}, #{level})")
    boolean add(Skill skill);

    @Update("UPDATE skill SET name = #{name}, level = #{level} WHERE id = #{id}")
    boolean update(Skill skill);

    @Select("SELECT id, name, level, created_time FROM skill")
    List<Skill> list();
}

