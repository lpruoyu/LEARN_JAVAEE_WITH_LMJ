package programmer.lp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@RequestMapping("/skill")
//@Controller
public class SkillController5 {
    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestParam(value = "username",required = true) String name,
                      @RequestParam(value = "password",required = true) String psword,
                      @RequestParam(value = "level", required = false) Integer skillLevel) {
        System.out.println(name);
        System.out.println(psword);
        System.out.println(skillLevel);
        return "Add Success!";
    }
}
