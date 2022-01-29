package programmer.lp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//@RequestMapping("/skill")
//@Controller
public class SkillController2 {
    @PostMapping("/add")
    @ResponseBody
    public String add(HttpServletRequest request) {
        System.out.println("username : " + request.getParameter("username"));
        System.out.println("password : " + request.getParameter("password"));
        System.out.println("level : " + request.getParameter("level"));
        return "Add Success!";
    }
}
