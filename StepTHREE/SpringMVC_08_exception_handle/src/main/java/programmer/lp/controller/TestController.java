package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/test1")
public class TestController {

    @RequestMapping("/demo1")
    @ResponseBody
    public String demo1(String birthday) {
        try {
            System.out.println("demo1");
            Date birth = new SimpleDateFormat("yyyy年MM月dd日").parse(birthday);
            System.out.println(birth);
        } catch (Exception e) {
            e.printStackTrace();
            // 处理异常！
        }
        return "success!";
    }

    @RequestMapping("/demo2")
    @ResponseBody
    public String demo2(String birthday) throws Exception {
        System.out.println("demo2");
        Date birth = new SimpleDateFormat("yyyy/MM/dd").parse(birthday);
        System.out.println(birth);
        return "success!";
    }

    @RequestMapping("/demo3")
    @ResponseBody
    public String demo3(String birthday) throws Exception {
        System.out.println("demo3");
        Date birth = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
        System.out.println(birth);
        System.out.println(1 / 0);
        return "success!";
    }

}
