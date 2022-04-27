package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlainController {
    @GetMapping(value = "/plainText", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String plainText() {
        return "好好读书！Good!";
    }

    //没produces 默认return text/html
    @GetMapping(value = "/plainText2")
    @ResponseBody
    public String plainText2() {
        return "好好读书！Good!";
    }

    @GetMapping(value = "/")
    @ResponseBody
    public String plainText3() {
        return "<font color='red'>#FF0000</font><br>" +
                "<font color='green'>#00FF00</font><br>" +
                "<font color='blue'>#0000FF</font>";
    }
}

