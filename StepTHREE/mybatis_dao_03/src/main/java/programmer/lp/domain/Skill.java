package programmer.lp.bean;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public class Skill {
    private Integer id;
    private String name;
    private Integer level;
    private Date createdTime;

    public Skill() {
        System.err.println("SKill()");
    }
//
    public Skill(@Param("name") String name, @Param("level") Integer level) {
        this.name = name;
        this.level = level;
    }

//    public Skill(String name, Integer level) {
//        this.name = name;
//        this.level = level;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}




