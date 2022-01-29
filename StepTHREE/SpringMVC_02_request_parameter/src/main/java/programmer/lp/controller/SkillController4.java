package programmer.lp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@RequestMapping("/skill")
//@Controller
public class SkillController4 {
    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestParam(value="username") String name,
                      @RequestParam("password") String psword,
                      @RequestParam("level") Integer skillLevel) {
        System.out.println(name);
        System.out.println(psword);
        System.out.println(skillLevel);
        return "Add Success!";
    }
}
