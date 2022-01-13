package programmer.lp.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import programmer.lp.domain.CarServiceImpl;

@Component
public class LifeCycleBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CarServiceImpl)
            System.out.println("5-BeanPostProcessor-postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CarServiceImpl)
            System.out.println("8-BeanPostProcessor-postProcessAfterInitialization");
        return bean;
    }
}
