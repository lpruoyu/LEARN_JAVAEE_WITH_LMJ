package programmer.lp.old.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component // 如果想要使用该切面，那么需要将其设为@Component，让IoC容器进行管理
public class DefaultAspect2 {

    @Around("within(programmer.lp.old.service.impl.UserServiceImpl)")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        System.out.println("DefaultAspect2 log start-------------------");

        // 调用目标方法
        final Object proceed = point.proceed();

        System.out.println("DefaultAspect2 log end-------------------");
        return proceed;
    }


}
