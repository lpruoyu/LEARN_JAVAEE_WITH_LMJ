package programmer.lp.resume.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import programmer.lp.resume.base.BaseBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact extends BaseBean {

    private String name;
    private String email;
    private String comment;
    private String subject;
    private Boolean alreadyRead = false;
    /*
    Java：Boolean  自动 数据库：INT
	      false                 0
	      true                  1
    */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getAlreadyRead() {
        return alreadyRead;
    }

    public void setAlreadyRead(Boolean alreadyRead) {
        this.alreadyRead = alreadyRead;
    }

    @Override
    @JsonIgnore
    public String getJson() {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            return objectMapper.writeValueAsString(this).replace("\"", "'"); // HTML中的onclick使用双引号
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static class Search {
        public Date beginDay;
        public Date endDay;
        public String keyWord;
        public Integer pageSize = 10; // 一页有多少条
        public Integer pageIndex = 1; // 第几页
        /*
            0 未读
            1 已读
            2 全部
        */
        public Integer alreadyRead = 2;
    }

}
