package programmer.lp.domain;

import java.math.BigDecimal;

public class Job {

    private String name;
    private String duty;
    private BigDecimal money;

    public Job() { }

    public Job(String name, String duty, BigDecimal money) {
        this.name = name;
        this.duty = duty;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
