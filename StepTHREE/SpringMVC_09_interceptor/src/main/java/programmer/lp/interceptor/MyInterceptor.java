package programmer.lp.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        // 每一个方法都有HandlerMethod，可以拿到controller的对象和方法
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        System.out.println(handlerMethod.getBean());
        System.out.println(handlerMethod.getMethod());

        System.out.println("preHandle");

        // 返回true代表不拦截该请求
        // 返回false代表拦截该请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
//        if (控制器) {
//            response.setHeader();
//        }
//        modelAndView.setViewName("");
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }

}
