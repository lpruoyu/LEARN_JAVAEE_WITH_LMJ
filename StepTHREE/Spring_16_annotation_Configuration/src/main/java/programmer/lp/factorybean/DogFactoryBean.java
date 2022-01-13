package programmer.lp.factorybean;

import org.springframework.beans.factory.FactoryBean;
import programmer.lp.domain.Dog;


//@Component("dog")
public class DogFactoryBean implements FactoryBean<Dog> {
    @Override
    public Dog getObject() throws Exception {
        // 假设Dog对象创建过程很复杂
        return new Dog();
    }

    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }
}
