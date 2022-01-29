package programmer.lp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import programmer.lp.domain.Skill;

//@RequestMapping("/skill")
//@Controller
public class SkillController8 {
    @PostMapping("/add")
    @ResponseBody
    public String add(Skill skill1, Skill skill2, String username, Integer level) {
        System.out.println(skill1);
        System.out.println(skill2);
        System.out.println(username);
        System.out.println(level);
        return "Add Success!";
    }
}
