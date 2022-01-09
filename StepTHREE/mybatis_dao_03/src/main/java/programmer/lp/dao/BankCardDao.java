package programmer.lp.dao;

import org.apache.ibatis.annotations.Select;
import programmer.lp.bean.BankCard;

import java.util.List;

public interface BankCardDao {
    @Select("SELECT id, no, amout FROM bank_card WHERE person_id = #{personId}")
    List<BankCard> listByPersonId(Integer personId);
}
