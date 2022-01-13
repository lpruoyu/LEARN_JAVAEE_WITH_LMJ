package programmer.lp.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("carService")
public class CarServiceImpl implements
        BeanNameAware, ApplicationContextAware,
        InitializingBean, DisposableBean {

    private String name;

    public CarServiceImpl() {
    }

    @Autowired
    public CarServiceImpl(@Value("LP") String name) {
        System.out.println("1-constructor");
    }

    @Value("lpruoyu")
    public void setName(String name) {
        this.name = name;
        System.out.println("2-setter");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("3-BeanNameAware-setBeanName");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4-ApplicationContextAware-setApplicationContext");
    }

    @PostConstruct
    public void init() {
        System.out.println("6-@PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7-InitializingBean-afterPropertiesSet");
    }

    public void mineMethod() {
        System.out.println("9-属于bean自己的方法（业务方法）");
    }

    @PreDestroy
    public void dealloc() {
        System.out.println("10-@PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11-DisposableBean-destroy");
    }

}
