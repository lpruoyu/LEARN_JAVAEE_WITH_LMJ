package programmer.lp.domain;

import java.util.Date;
import java.util.List;

public class Hobby {

    private String info;
    private Date time;
    private List<String> hobbies;

    public Hobby() {
    }

    public Hobby(String info, Date time, List<String> hobbies) {
        this.info = info;
        this.time = time;
        this.hobbies = hobbies;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
