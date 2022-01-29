package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Redirect5Controller {
    @GetMapping("/redirect5")
    public ModelAndView redirect5() {
        ModelAndView mv = new ModelAndView("redirect:/showInfo.jsp");
        mv.addObject("name", "ruoyu");
        mv.addObject("age", "18");
        return mv;
    }
}
