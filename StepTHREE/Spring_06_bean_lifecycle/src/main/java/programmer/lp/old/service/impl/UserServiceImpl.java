package programmer.lp.old.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import programmer.lp.old.service.UserService;

public class UserServiceImpl implements UserService,
        BeanNameAware, ApplicationContextAware,
        InitializingBean, DisposableBean {

    // 构造注入
    public UserServiceImpl() {
        System.out.println("constructor");
    }

    // setter注入
    public void setAge(Integer age) {
        System.out.println("setter");
    }

    // 告诉bean：你叫什么名字
    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware-setBeanName : " + name);
    }

    // 告诉bean：你是被哪个容器创建出来的，属于哪个容器
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware-setApplicationContext : " + applicationContext);
    }

    // 以上四个方法是为bean的初始化做准备

    // 接口配置的初始化方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean - afterPropertiesSet");
    }

    // XML中通过 init-method="init" 配置的初始化方法
    public void init() {
        System.out.println("init-method");
    }

    // 业务方法（可以存在多个）
    @Override
    public void login(String username, String password) {
        System.out.println("业务方法");
    }

    // 接口配置的销毁方法
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean - destroy");
    }

    // XML中通过 destroy-method="dealloc" 配置的销毁方法
    public void dealloc() {
        System.out.println("dealloc-method");
    }

}
