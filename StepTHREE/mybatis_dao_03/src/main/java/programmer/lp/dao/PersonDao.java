package programmer.lp.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import programmer.lp.bean.Person;

import java.util.List;

public interface PersonDao {
    @Select("SELECT id, name FROM person WHERE id = #{id}")
    @Results(
            id = "rmListPerson",
            value={
                    @Result(property = "id", column = "id", id = true),
                    @Result(property = "name", column = "name"),
                    @Result(
                            property = "idCard",
                            column = "id",
                            one = @One(fetchType = FetchType.LAZY, select = "programmer.lp.dao.IdCardDao.getByPersonId")
                    ),
                    @Result(
                            property = "bankCards",
                            column = "id",
                            many = @Many(fetchType = FetchType.LAZY, select = "programmer.lp.dao.BankCardDao.listByPersonId")
                    ),
                    @Result(
                            property = "jobs",
                            column = "id",
                            many = @Many(fetchType = FetchType.LAZY, select = "programmer.lp.dao.JobDao.listByPersonId")
                    )
            }
    )
    Person get(Integer id);

    @Select("SELECT id, name FROM person")
    @ResultMap("rmListPerson")
    List<Person> list();
}
