package programmer.lp.factorybean;

import org.springframework.beans.factory.FactoryBean;
import programmer.lp.domain.Food;

public class FoodFactoryBean implements FactoryBean<Food> {
    @Override
    public Food getObject() throws Exception {
        // 假设Food对象创建过程很复杂
        return new Food();
    }

    @Override
    public Class<?> getObjectType() {
        return Food.class;
    }
}