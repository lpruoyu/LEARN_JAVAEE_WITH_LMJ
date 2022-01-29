package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SkillController {
    @PostMapping("/skill/add")
    @ResponseBody
    public String add(String username, String password, Integer level) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(level);
        return "Add Success!";
    }
}
