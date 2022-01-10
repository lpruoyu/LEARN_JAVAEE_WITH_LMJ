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
        // 需要考虑清楚哪些bean需要代理、哪些bean不需要代理
        // 并写出相应的控制代码
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

        // 以CGLib-MethodInterceptor-intercept方法为例
        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            // 假设现在只想代理 boolean login(String username, String password); 方法
            String methodName = method.getName();
            Class<?> methodReturnType = method.getReturnType();
            Class<?>[] methodParameterTypes = method.getParameterTypes();
            if ("login".equals(methodName)
                    && methodParameterTypes.length == 2
                    && methodParameterTypes[0] == String.class
                    && methodParameterTypes[1] == String.class
                    && methodReturnType == Boolean.class) {
                System.out.println("代理-----------start-----------日志/事务...");

                Object result = method.invoke(target, args);

                System.out.println("代理-----------end-----------日志/事务...");
                return result;
            }
            return method.invoke(target, args);
        }
    }


//
//    private static class LogMethodInterceptor implements MethodInterceptor {
//        Object target;
//
//        public LogMethodInterceptor(Object target) {
//            this.target = target;
//        }
//
//        // 以CGLib-MethodInterceptor-intercept方法为例
//        @Override
//        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//            // 假设现在只想代理 boolean login(String username, String password); 方法
//            String methodName = method.getName();
//            Class<?> methodReturnType = method.getReturnType();
//            Class<?>[] methodParameterTypes = method.getParameterTypes();
//
//            System.out.println(methodName);
//            System.out.println(methodReturnType);
//            System.out.println(Arrays.toString(methodParameterTypes));
//
//            if ("login".equals(methodName)
//                    && methodParameterTypes.length == 2
//                    && methodParameterTypes[0] == String.class
//                    && methodParameterTypes[1] == String.class
//                    && methodReturnType == Boolean.class) {
//                System.out.println("代理-----------start-----------日志/事务...");
//
//                Object result = method.invoke(target, args);
//
//                System.out.println("代理-----------end-----------日志/事务...");
//                return result;
//            }
//            return method.invoke(target, args);
//        }
//    }

}
