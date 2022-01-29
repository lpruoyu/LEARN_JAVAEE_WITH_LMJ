package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HTMLController {
    @GetMapping(value = "/htmlText", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String htmlText() {
        return  "<font color='red'>#FF0000</font><br>" +
                "<font color='green'>#00FF00</font><br>" +
                "<font color='blue'>#0000FF</font>";
    }
}

