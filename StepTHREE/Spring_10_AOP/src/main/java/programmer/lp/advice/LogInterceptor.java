package programmer.lp.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("代理 start ------------------------------------");
        Object result = methodInvocation.proceed();
        System.out.println("代理 end ------------------------------------");
        return result;
    }
}
