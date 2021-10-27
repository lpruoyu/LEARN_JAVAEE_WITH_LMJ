package programmer.lp.resume.dao;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import programmer.lp.resume.bean.Education;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EducationDao extends BaseDao {

    static {
        // 配置BeanUtils：String -> Date
        DateConverter dateConverter = new DateConverter(null);
        dateConverter.setPatterns(new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"});
        ConvertUtils.register(dateConverter, Date.class);
    }

    public List<Education> list() {
        String sql = "SELECT id, created_time, last_update_time, name, type, intro, begin_day, end_day FROM education ORDER BY type ASC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Education.class));
    }

    public boolean save(Education education) {
        String sql;
        List<Object> args = new ArrayList<>(10);
        args.add(education.getName());
        args.add(education.getType());
        args.add(education.getIntro());
        args.add(education.getBeginDay());
        args.add(education.getEndDay());
        if (education.getId() == null) { // 插入一条数据
            sql = "INSERT INTO education(name, type, intro, begin_day, end_day) VALUES(?, ?, ?, ?, ?)";
        } else { // 更新该条数据
            sql = "UPDATE education SET name = ?, type = ?, intro = ?, begin_day = ?, end_day = ? WHERE id = ?";
            args.add(education.getId());
        }
        return jdbcTemplate.update(sql, args.toArray()) == 1;
    }

//    public boolean remove(Integer id) {
//        String sql = "DELETE FROM education WHERE id = ?";
//        return jdbcTemplate.update(sql, id) == 1;
//    }

    public boolean removeAll(String[] ids) {
        List<Integer> args = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM education WHERE id in (");
        for (String id : ids) {
            args.add(Integer.valueOf(id));
            sb.append("?, ");
        }
        sb.replace(sb.length() - 2, sb.length(), ")");
        return jdbcTemplate.update(sb.toString(), args.toArray()) > 0;
    }

}
