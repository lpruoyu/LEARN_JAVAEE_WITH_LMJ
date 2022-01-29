package programmer.lp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//@RequestMapping("/skill")
public class SkillController9 {
    @GetMapping("/get")
    @ResponseBody
    public String get(Integer id) {
        return "id : " + id;
//        Skill skill = service.get(id);
//        return skill;
    }
}
