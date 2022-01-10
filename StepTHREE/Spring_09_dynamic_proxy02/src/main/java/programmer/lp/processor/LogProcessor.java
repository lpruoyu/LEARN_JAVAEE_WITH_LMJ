package programmer.lp.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return Proxy.newProxyInstance(
                getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                new LogProcessorInvocationHandler(bean));
    }

    // 这个类就可以专心写好代理方法（附加代码）了，当然，也可以将该类单独抽取出一个.java文件
    private static class LogProcessorInvocationHandler implements InvocationHandler {
        Object target;
        LogProcessorInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("proxy----------日志/事务...---------before");

            Object result = method.invoke(target, args);

            System.out.println("proxy----------日志/事务...------------end");
            return result;
        }
    }

}


//// BeanPostProcessor会拦截每一个bean的生命周期
//public class LogProcessor implements BeanPostProcessor {
//
//    @Override                                    // 这个bean就是目标对象
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        // 为目标对象生成代理对象，并将生成的代理对象返回，将该代理对象return后
//        // 控制层通过getBean方法拿到的就是目标对象的代理对象
//        return Proxy.newProxyInstance(
//                this.getClass().getClassLoader(),
//                bean.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    // 代理方法
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("proxy----------日志/事务...---------before");
//
//                        // 调用目标对象的目标方法
//                        Object result = method.invoke(bean, args);
//
//                        System.out.println("proxy----------日志/事务...------------end");
//                        return result;
//                    }
//                });
//    }
//
//}
