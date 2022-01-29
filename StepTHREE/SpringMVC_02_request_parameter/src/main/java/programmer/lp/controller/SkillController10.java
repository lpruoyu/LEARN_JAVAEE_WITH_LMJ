package programmer.lp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//@RequestMapping("/skill")
public class SkillController10 {
    @GetMapping("/get/{skillId}")
    @ResponseBody
    public String get(@PathVariable("skillId") Integer id) {
        return "id : " + id;
//        Skill skill = service.get(id);
//        return skill;
    }
}
