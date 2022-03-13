package programmer.lp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Skill {
    private Integer id;
    private Date createdTime;
    private String name;
    private Integer level;

    public Skill() {
    }

    public Skill(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", createdTime=" + createdTime +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
