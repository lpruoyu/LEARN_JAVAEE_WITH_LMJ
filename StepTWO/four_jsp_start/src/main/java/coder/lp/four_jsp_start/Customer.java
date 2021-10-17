package coder.lp.four_jsp_start;

public class Customer {

    private String name;
    private String phone;
    private String sex;

    public Customer(String name, String phone, String sex) {
        this.name = name;
        this.phone = phone;
        this.sex = sex;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
