package programmer.lp.learn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AllAnnotationAop {

    @Around("within(programmer.lp.learn..*)")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        System.out.println("AllAnnotationAop-------------------------start");
        Object result = point.proceed();
        System.out.println("AllAnnotationAop-------------------------end");
        return result;
    }

}
