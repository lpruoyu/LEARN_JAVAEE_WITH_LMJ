package programmer.lp.domain;

public class Dog {
    private String name;
    private String age;
    private Dog[] children;
    public Dog() { }

    public Dog(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Dog[] getChildren() {
        return children;
    }

    public void setChildren(Dog[] children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
