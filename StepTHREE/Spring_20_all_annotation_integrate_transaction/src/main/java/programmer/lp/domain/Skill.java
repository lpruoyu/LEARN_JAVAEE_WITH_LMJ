package programmer.lp.domain;

import java.util.Date;

public class Skill {

    private Integer id;
    private Integer level;
    private String name;
    private Date createdTime;

    public Skill() {
    }

    public Skill(String name, Integer level) {
        this.level = level;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
