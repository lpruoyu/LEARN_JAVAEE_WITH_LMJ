package programmer.lp.resume.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import programmer.lp.resume.bean.Website;

import java.util.ArrayList;
import java.util.List;

public class WebsiteDao extends BaseDao {

    /**
     * @return 返回website表中的所有数据
     */
    public List<Website> list() {
        String sql = "SELECT id, created_time, last_update_time ,footer FROM website";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Website.class));
    }

    public boolean save(Website website) {
        String sql;
        List<Object> args = new ArrayList<>(10);
        args.add(website.getFooter());
        if (website.getId() == null) { // 插入一条数据
            sql = "INSERT INTO website(footer) VALUES(?)";
        } else { // 更新该条数据
            sql = "UPDATE website SET footer = ? WHERE id = ?";
            args.add(website.getId());
        }
        return jdbcTemplate.update(sql, args.toArray()) == 1;
    }

}
