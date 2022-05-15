package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@Import(MyExceptionResolver.class)
public class ExceptionController {

    @GetMapping("/exception1")
    @ResponseBody
    public String exception1() {
        System.out.println(1 / 0);
        return "exception1";
    }

    @GetMapping("/exception2")
    @ResponseBody
    public String exception2() {
        int[] arr = {1};
        System.out.println(arr[3]);
        return "exception2";
    }

    @GetMapping("/exception3")
    @ResponseBody
    public String exception3() {
        if(true) {
            throw new RuntimeException("运行时异常");
        }
        return "exception3";
    }

}
