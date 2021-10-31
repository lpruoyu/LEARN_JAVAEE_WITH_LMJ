package programmer.lp.resume.base;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import programmer.lp.resume.util.Dbs;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDaoImpl<T extends BaseBean> implements BaseDao<T> {

    protected abstract String tableName();

    @Override
    public Integer count() {
        final String sql = "SELECT COUNT(*) FROM " + tableName();
        return Dbs.jdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<>(Integer.class));
    }

    @Override
    public boolean remove(Integer id) {
        return removeAll(new Integer[]{id});
    }

//    public boolean remove(Integer id) {
//        String sql = "DELETE FROM education WHERE id = ?";
//        return Dbs.jdbcTemplate().update(sql, id) == 1;
//    }

    @Override
    public boolean removeAll(Integer[] ids) {
        List<Integer> args = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ").append(tableName()).append(" WHERE id in (");
        for (Integer id : ids) {
            args.add(id);
            sb.append("?, ");
        }
        sb.replace(sb.length() - 2, sb.length(), ")");
        return Dbs.jdbcTemplate().update(sb.toString(), args.toArray()) > 0;
    }

    @Override
    public boolean update(T base) {
        return false;
    }

}
