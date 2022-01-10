package programmer.lp.dao;

import org.apache.ibatis.annotations.Update;
import programmer.lp.domain.Skill;

import java.util.List;
public interface SkillDao {
    boolean add(Skill skill);
    boolean adds(List<Skill> skills);
    boolean remove(Integer id);
    @Update("UPDATE skill SET name = #{name}, level = #{level} WHERE id = #{id}")
    boolean update(Skill skill);
    Skill get(Integer id);
    List<Skill> list();
}

