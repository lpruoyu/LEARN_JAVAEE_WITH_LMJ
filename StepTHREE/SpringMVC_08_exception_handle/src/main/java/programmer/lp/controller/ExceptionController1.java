package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.time.DateTimeException;

@Controller
@RequestMapping("/exception1")
public class ExceptionController1 {

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

}