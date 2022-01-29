package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.DateTimeException;

@Controller
@RequestMapping("/ex2")
public class ExceptionController2 {

    @RequestMapping("/demo1")
    @ResponseBody
    public String demo1() {
        throw new DateTimeException("demo1");
    }

    @RequestMapping("/demo2")
    @ResponseBody
    public String demo2() throws Exception {
        throw new IOException("demo2");
    }

    @RequestMapping("/demo3")
    @ResponseBody
    public String demo3() {
        throw new ArithmeticException("demo3");
    }

    //    需要特殊处理的异常
//    @ExceptionHandler(DateTimeException.class)
//    public void exceptionHandlerSpecial1(Exception ex) {
//        System.out.println(ex);
//    }
//
//    @ExceptionHandler(ArithmeticException.class)
//    public ModelAndView exceptionHandlerSpecial2(Exception ex) {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("ex", ex);
//        mv.setViewName("/WEB-INF/error/runtime.jsp");
//        System.out.println(ex);
//        return mv;
//    }

    //    需要特殊处理的异常
    @ExceptionHandler({DateTimeException.class, ArithmeticException.class})
    public void exceptionHandlerSpecial(Exception ex) {
        System.out.println(ex);
    }

    // 其余所有的异常
    @ExceptionHandler
    public ModelAndView exceptionHandlerOther(Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex", ex);
        mv.setViewName("/WEB-INF/error/default.jsp");
        return mv;
    }

}