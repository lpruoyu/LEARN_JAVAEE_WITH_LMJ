package programmer.lp.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LogProcessor2 implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!bean.getClass().getName().startsWith("programmer.lp.service.")) {
            return bean;
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(getClass().getClassLoader());
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(new LogMethodInterceptor(bean));
        return enhancer.create();
    }

    private static class LogMethodInterceptor implements MethodInterceptor {
        Object target;

        public LogMethodInterceptor(Object target) {
            this.target = target;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("代理-----------start-----------日志/事务...");

            Object result = method.invoke(target, args);

            System.out.println("代理-----------end-----------日志/事务...");
            return result;
        }
    }

}
