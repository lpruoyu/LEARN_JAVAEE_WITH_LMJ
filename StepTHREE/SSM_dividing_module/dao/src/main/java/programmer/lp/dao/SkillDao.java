package programmer.lp.dao;

import org.apache.ibatis.annotations.*;
import programmer.lp.domain.Skill;

import java.util.List;

public interface SkillDao {
    @Insert("INSERT INTO skill(name, level) VALUES(#{name}, #{level})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",
            keyProperty = "id",
            keyColumn = "id",
            before = false,
            resultType = Integer.class)
    boolean insert(Skill skill);

    @Delete(("DELETE FROM skill WHERE id = #{id}"))
    boolean delete(Integer id);

    @Update("UPDATE skill SET name = #{name}, level = #{level} WHERE id = #{id}")
    boolean update(Skill skill);

    @Select("SELECT id, created_time, name, level FROM skill WHERE id = #{id}")
    Skill get(Integer id);

    @Select("SELECT id, created_time, name, level FROM skill")
    List<Skill> list();
}
