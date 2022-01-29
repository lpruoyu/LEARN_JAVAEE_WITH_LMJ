package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/skill")
public class SkillController {
    /*
        /skill/add
    */
    @RequestMapping("/add")
    @ResponseBody
    public String add() {
        return "SkillController - Add Success!";
    }

    /*
        /skill/remove
    */
    @RequestMapping("/remove")
    @ResponseBody
    public String remove() {
        return "SkillController - Remove Success!";
    }
}
