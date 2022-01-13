package programmer.lp.domain;

//@Component
//@Import({
//        Person.class,
//        Food.class,
//        Human.class
//})

//@ComponentScan({
//        "programmer.lp.domain1",
//        "programmer.lp.domain2"
//})

//@ComponentScans({
//        @ComponentScan("programmer.lp.domain1"),
//        @ComponentScan("programmer.lp.domain2")
//})

public class Dog {
    private String name;
    private String nickName;

    public Dog() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
