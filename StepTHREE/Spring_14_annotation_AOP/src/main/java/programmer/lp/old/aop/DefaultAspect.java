package programmer.lp.old.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
// @Component // 如果想要使用该切面，那么需要将其设为@Component，让IoC容器进行管理
public class DefaultAspect {

    @Pointcut("within(programmer.lp.old.service.impl.UserServiceImpl)")
//    @Pointcut("within(programmer.lp.old.service..*)")
    public void pointcut() {}

    // 日志
    @Around("pointcut()")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        System.out.println("log start-------------------");

        // 调用目标方法
        final Object result = point.proceed();

        System.out.println("log end-------------------");
        return result;
    }

    // 监控
    @Around("pointcut()")
    public Object watch(ProceedingJoinPoint point) throws Throwable {
        System.out.println("watch start-------------------");

        // 调用目标方法
        final Object result = point.proceed();

        System.out.println("watch end-------------------");
        return result;
    }

}
