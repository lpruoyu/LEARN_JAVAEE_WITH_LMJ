package com.mj.bean;

import com.mj.bean.base.Bean;

/**
 * 奖项或者成就
 */
public class Award extends Bean {
    /**
     * 多张图片之间用逗号隔开
     */
    private String image;
    private String name;
    private String intro;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
