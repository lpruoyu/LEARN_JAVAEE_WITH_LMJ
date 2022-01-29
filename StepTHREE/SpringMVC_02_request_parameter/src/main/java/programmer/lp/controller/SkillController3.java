package programmer.lp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RequestMapping("/skill")
//@Controller
public class SkillController3 {
    @PostMapping("/add")
    @ResponseBody
    public String add(String username, String password, Integer level) {
        System.out.println(level);
        System.out.println(username);
        System.out.println(password);
        return "Add Success!";
    }
}
