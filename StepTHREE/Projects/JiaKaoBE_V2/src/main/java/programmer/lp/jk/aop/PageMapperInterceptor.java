package programmer.lp.jk.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import programmer.lp.jk.enhance.MPPage;

@Aspect
@Component
public class PageMapperInterceptor {
    @Around("execution(public com.baomidou.mybatisplus.core.metadata.IPage com.baomidou.mybatisplus.core.mapper.BaseMapper.selectPage(com.baomidou.mybatisplus.core.metadata.IPage, com.baomidou.mybatisplus.core.conditions.Wrapper))")
    public Object updateQuery(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        final Object[] args = point.getArgs();
        if (args != null && args.length > 0) {
            Object arg = args[0];
            if (arg instanceof MPPage) {
                ((MPPage<?>) arg).updateQuery();
            }
        }
        return result;
    }
}
