package com.mj.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mj.bean.base.Bean;

public class Skill extends Bean {
    private String name;
    /**
     * 0: 了解
     * 1: 熟悉
     * 2: 掌握
     * 3: 精通
     */
    private Integer level;

    @JsonIgnore
    public String getLevelString() {
        switch (level) {
            case 1: return "熟悉";
            case 2: return "掌握";
            case 3: return "精通";
            default: return "了解";
        }
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
}
