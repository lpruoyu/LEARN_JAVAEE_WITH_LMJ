package programmer.lp.old.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyAop implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(getClass().getClassLoader());
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(new MethodInterceptorHandler(bean));
        return enhancer.create();
    }

    private static class MethodInterceptorHandler implements MethodInterceptor {
        Object target;

        public MethodInterceptorHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("------my-----------start-------------");

            final Object result = method.invoke(target, objects);

            System.out.println("------my-----------end-------------");
            return result;
        }
    }

}
