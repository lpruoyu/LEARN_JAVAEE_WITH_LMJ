package programmer.lp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.DateTimeException;

@ControllerAdvice
public class MyExceptionHandler {

    // 默认处理所有的异常
    @ExceptionHandler
    public ModelAndView exceptionHandlerOther(Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex", ex);
        mv.setViewName("/WEB-INF/error/default.jsp");
        return mv;
    }

    // 需要特殊处理的异常
    @ExceptionHandler({DateTimeException.class, ArithmeticException.class})
    @ResponseBody
    public String exceptionHandlerSpecial(Exception ex) {
        System.out.println(ex);
        return "出现了异常:" + ex;
    }

}
