package programmer.lp.dao;

import org.apache.ibatis.annotations.Insert;
import programmer.lp.domain.Skill;

import java.util.List;

public interface SkillDao {
    Skill get(Integer id);
    List<Skill> list();
    @Insert("INSERT INTO skill(name, level) VALUES(#{name}, #{level})")
    boolean save(Skill skill);
}
