package programmer.lp.old.service;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SkillService implements ApplicationContextAware, BeanNameAware {
    private ApplicationContext applicationContext;
    private String beanName;

    public void delete(Integer id) {
//        直接调用other这个目标方法，other不会被代理
//        other();
//        如果要想other也被代理：

        SkillService skillService = applicationContext.getBean(beanName, SkillService.class);
        skillService.other();
        System.out.println("SkillService-delete-核心业务");
    }

    public void other() {
        System.out.println("other");
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

//
//public class SkillService  {
//
//    public void delete(Integer id) {
////        直接调用other这个目标方法，other不会被代理
////        other();
//        System.out.println("SkillService-delete-核心业务");
//    }
//
//    public void other() {
//        System.out.println("other");
//    }
//
//}
