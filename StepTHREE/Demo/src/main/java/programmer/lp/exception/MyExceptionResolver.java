package programmer.lp.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {
//      可以使用request、response对象

//      可以通过handler知道是哪个Controller的哪个方法出现了异常
//      拿到具体的Controller和具体的方法后，就可以做出相应的处理
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        System.out.println(handlerMethod.getBean());
        System.out.println(handlerMethod.getMethod());

        System.out.println("request.getRequestURL()    " + request.getRequestURL());

        ModelAndView mv = new ModelAndView();
//      自己可以根据异常的类型决定去哪个异常处理页面
//      对某种类型的异常做特殊处理
//      if (ex instanceof ArrayIndexOutOfBoundsException) {
//          mv.setViewName("xxx");
//      } else if (ex instanceof IOException) {
//          mv.setViewName("xxx");
//      }else if(ex instanceof xxx) {
//          // ...
//      }else {
//          mv.setViewName("default.jsp");
//      }
        mv.setViewName("/WEB-INF/error/default.jsp");

//      可以给异常处理页面传递任何信息
//      mv.addObject(attributeName,attributeValue);
        mv.addObject("ex", ex);
        mv.addObject("path", request.getRequestURL());
//        mv.addObject("userinfo", "name:lp, age:10,...");
        return mv;
    }
}
