package programmer.lp.bean;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public class Skill {
    private String name;
    private Integer level;
    private Date createdTime;
    private Integer id;

    public Skill() {
        System.err.println("默认");
    }

    public Skill(@Param("level") Integer level, @Param("name") String name) {
        System.err.println("level name");
        this.name = name;
        this.level = level;
    }

    public Skill(@Param("name") String name, @Param("level") Integer level) {
        System.err.println("name level");
        this.name = name;
        this.level = level;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
                "name='" + name + '\'' +
                ", level=" + level +
                ", createdTime=" + createdTime +
                '}';
    }
}
