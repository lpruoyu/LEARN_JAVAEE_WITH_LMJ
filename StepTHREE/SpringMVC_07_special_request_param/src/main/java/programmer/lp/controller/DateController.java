package programmer.lp.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/date")
public class DateController {
    @RequestMapping("/demo2")
    @ResponseBody
    public String demo2(String username, Date birthday) {
        System.out.println("demo2");
        System.out.println(username + "__" + birthday);
        return "success";
    }

    @RequestMapping("/demo1")
    @ResponseBody
    public String demo1(String username, @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday) {
        System.out.println(username + "__" + birthday);
        return "success";
    }
}
