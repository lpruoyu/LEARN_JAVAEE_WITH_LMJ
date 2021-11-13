package programmer.lp.resume.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import programmer.lp.resume.base.BaseDaoImpl;
import programmer.lp.resume.bean.Contact;
import programmer.lp.resume.dao.ContactDao;
import programmer.lp.resume.util.Strings;

import java.util.ArrayList;
import java.util.List;

public class ContactDaoImpl extends BaseDaoImpl<Contact> implements ContactDao {

    @Override
    public boolean save(Contact bean) {
        String sql;
        List<Object> args = new ArrayList<>();
        args.add(bean.getName());
        args.add(bean.getEmail());
        args.add(bean.getComment());
        args.add(bean.getSubject());
        args.add(bean.getAlreadyRead());
        args.add(bean.getCreatedTime());
        final Integer id = bean.getId();
        final String tableName = tableName();
        if (id == null || id < 1) { // 插入一条数据
            sql = "INSERT INTO " + tableName + "(name, email, comment, subject, already_read, created_time) VALUES(?, ?, ?, ?, ?, ?)";
        } else { // 更新该条数据
            sql = "UPDATE " + tableName + " SET name = ?, email = ?, comment = ?, subject = ?, already_read = ?, created_time = ? WHERE id = ?";
            args.add(id);
        }
        return JDBCTEMPLATE.update(sql, args.toArray()) == 1;
    }

    @Override
    public List<Contact> list() {
        final String sql = "SELECT id, created_time, last_update_time, name, email, comment, subject, already_read FROM " + tableName();
        return JDBCTEMPLATE.query(sql, new BeanPropertyRowMapper<>(Contact.class));
    }

    public List<Contact> list(Contact.Search search) {
        StringBuilder sb = new StringBuilder();
        List<Object> args = new ArrayList<>();
        sb.append("SELECT id, created_time, last_update_time, name, email, comment, subject, already_read FROM ");
        sb.append(tableName());
        sb.append(" WHERE 1 = 1 "); // 技巧
        if (search.beginDay != null) {
            sb.append("AND created_time >= ? ");
            args.add(search.beginDay);
        }
        if (search.endDay != null) {
            sb.append("AND created_time <= ? ");
            args.add(search.endDay);
        }
        if (Strings.isNotNull(search.keyWord)) {
            sb.append("AND (name LIKE ? OR email LIKE ? OR comment LIKE ? OR subject LIKE ?) ");
            final String keyWord = "%" + search.keyWord + "%";
            args.add(keyWord);
            args.add(keyWord);
            args.add(keyWord);
            args.add(keyWord);
        }
        if (search.alreadyRead < 2) {
            sb.append("AND already_read = ? ");
            args.add(search.alreadyRead);
        }
        sb.append("LIMIT ?, ?");
        args.add((search.pageIndex - 1) * search.pageSize);
        args.add(search.pageSize);
        return JDBCTEMPLATE.query(sb.toString(), new BeanPropertyRowMapper<>(Contact.class), args.toArray());
    }

}