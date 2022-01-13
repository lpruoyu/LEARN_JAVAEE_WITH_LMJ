package programmer.lp.old.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import programmer.lp.annotation.Log;
import programmer.lp.old.service.UserService;

public class UserServiceImpl3 implements UserService, ApplicationContextAware , BeanNameAware {

    private ApplicationContext applicationContext;
    private String beanName;

    @Override
    @Log // 目标方法：需要代理
    public boolean login(String username, String password) {
        System.out.println("--------------------login--------------------");
        // 通过同一个id、在同一个容器下获取到的scope为singleton的对象永远是同一个
        // 可以理解为一个ApplicationContext就是一个容器

        // 把代理对象拿出来
        UserService userService =  applicationContext.getBean(beanName, UserService.class);
        if (userService.register(username, password)) {
            return "lpruoyu".equals(username) && "123456".equals(password);
        }
        return false;
    }

    @Override
    @Log // 目标方法：需要代理
    public boolean register(String username, String password) {
        System.out.println("--------------------register--------------------");
        return username.equals(password);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

}