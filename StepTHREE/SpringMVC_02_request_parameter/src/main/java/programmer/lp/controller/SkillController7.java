package programmer.lp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import programmer.lp.domain.Skill;

//@RequestMapping("/skill")
//@Controller
public class SkillController7 {
    @PostMapping("/add")
    @ResponseBody
    public String add(Skill skill) {
        System.out.println(skill);
        return "Add Success!";
    }
}
