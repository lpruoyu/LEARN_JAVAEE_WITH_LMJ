package programmer.lp.dao;

import org.apache.ibatis.annotations.*;
import programmer.lp.bean.Skill;

import java.util.List;

//@CacheNamespace()
public interface SkillDao {
    //    @Insert("INSERT INTO skill(name, level) VALUES(#{name}, #{level})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    @SelectKey(
//            statement = "SELECT LAST_INSERT_ID()",
//            resultType = Integer.class,
//            keyProperty = "id",
//            before = false
//    )
    boolean add(Skill skill);

    @Delete(value = "DELETE FROM skill WHERE id = #{id}")
    boolean remove(Integer id);

    @Update("UPDATE skill SET name = #{name}, level = #{level} WHERE id = #{id}")
    boolean update(Skill skill);

    @Select("SELECT id, name, level, created_time FROM skill WHERE id = #{id}")
    Skill get(Integer id);


    @Select("SELECT id, name, level, created_time FROM skill")
    @ConstructorArgs({
            @Arg(column = "level", name = "level"),
            @Arg(column = "name", name = "name")
    })
    List<Skill> list();

//    @Select("SELECT id, name, level, created_time FROM skill")
//    @ConstructorArgs({
//            @Arg(column = "name", javaType = String.class),
//            @Arg(column = "level", javaType = Integer.class)
//    })
//    List<Skill> list();

    @Select("SELECT id, name, level, created_time FROM skill LIMIT #{start}, #{size}")
    List<Skill> listPage(Integer start, Integer size);
}

