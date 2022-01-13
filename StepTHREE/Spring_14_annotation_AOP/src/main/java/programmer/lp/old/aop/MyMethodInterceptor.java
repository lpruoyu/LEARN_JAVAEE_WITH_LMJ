package programmer.lp.old.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("MyMethodInterceptor start--------------");

        Object result = methodInvocation.proceed();

        System.out.println("MyMethodInterceptor end--------------");
        return result;
    }

}