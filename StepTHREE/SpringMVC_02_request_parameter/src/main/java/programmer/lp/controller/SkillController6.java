package programmer.lp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@RequestMapping("/skill")
//@Controller
public class SkillController6 {
    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestParam String username,
                      @RequestParam String password,
                      @RequestParam Integer level) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(level);
        return "Add Success!";
    }
}
