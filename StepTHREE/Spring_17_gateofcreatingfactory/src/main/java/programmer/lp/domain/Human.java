package programmer.lp.domain;

import org.springframework.beans.factory.annotation.Autowired;

//@Component
//@Component("human")
public class Human {
    private Food food;
    @Autowired
    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Human{" +
                "food=" + food +
                '}';
    }
}
