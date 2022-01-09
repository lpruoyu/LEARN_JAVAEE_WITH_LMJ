package programmer.lp.domain;

public class Human {

    private String name;
    private Integer age;
    private Job job;
    private Hobby hobby;

    public Human() {
    }

    public Human(String name, Integer age, Job job, Hobby hobby) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

}

