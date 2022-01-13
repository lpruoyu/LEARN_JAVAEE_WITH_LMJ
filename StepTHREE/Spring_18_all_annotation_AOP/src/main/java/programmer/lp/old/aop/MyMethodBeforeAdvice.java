package programmer.lp.old.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyMethodBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("MyMethodBeforeAdvice--------------start---------------");
        method.invoke(o, objects);
        System.out.println("MyMethodBeforeAdvice--------------end-----------------");
    }

}
