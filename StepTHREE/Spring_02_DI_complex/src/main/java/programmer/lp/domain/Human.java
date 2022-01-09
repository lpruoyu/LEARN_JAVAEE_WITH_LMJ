package programmer.lp.domain;

import java.util.Date;

public class Human {

    private String name;
    private String favoriteFood;
    private Date birthday;
    private Food food;
    private Integer fnByteLength;

    public Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getFnByteLength() {
        return fnByteLength;
    }

    public void setFnByteLength(Integer fnByteLength) {
        this.fnByteLength = fnByteLength;
    }
}
