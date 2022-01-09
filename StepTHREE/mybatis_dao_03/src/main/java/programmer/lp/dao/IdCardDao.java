package programmer.lp.dao;

import org.apache.ibatis.annotations.Select;
import programmer.lp.bean.IdCard;

public interface IdCardDao {
    @Select("SELECT id, no, address FROM id_card WHERE person_id = #{personId}")
    IdCard getByPersonId(Integer personId);
}
