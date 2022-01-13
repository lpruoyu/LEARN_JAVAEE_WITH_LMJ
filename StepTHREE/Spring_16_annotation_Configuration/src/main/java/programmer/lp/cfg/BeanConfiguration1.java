package programmer.lp.cfg;

import programmer.lp.domain.Dog;

//@Configuration
public class BeanConfiguration1 {

    // @Bean("babyDog")
    public Dog dog() {
        return new Dog();
    }

}
