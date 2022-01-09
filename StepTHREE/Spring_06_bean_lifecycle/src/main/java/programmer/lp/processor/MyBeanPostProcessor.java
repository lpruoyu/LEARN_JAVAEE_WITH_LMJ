package programmer.lp.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    // 初始化之前
    // 此方法意味着bean已经做好了初始化的准备，正式开始初始化
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor - before");
        return bean;
    }

    // 初始化之后
    // 此方法执行后，bean的初始化就彻底结束了，就进入了就绪状态，之后就可以去处理属于自己的业务方法了（业务方法被调用时）
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor - after");
        return bean;
    }

}
