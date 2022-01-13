package programmer.lp.old.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class DefaultAspect {

    @Around("within(programmer.lp.old.service..*)")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        System.out.println("DefaultAspect---------start------------");

        final Object result = point.proceed();

        System.out.println("DefaultAspect---------end------------");
        return result;
    }

}