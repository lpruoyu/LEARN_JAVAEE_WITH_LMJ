package programmer.lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import programmer.lp.domain.Skill;
import programmer.lp.service.SkillService;

import java.util.List;

//@RestController
@RequestMapping("/skills")
public class SkillController3 {
    @Autowired
    private SkillService service;

    @GetMapping("/{id}")
    public Skill get(@PathVariable("id") Integer id) {
        return service.get(id);
    }

    @GetMapping
    public List<Skill> list() {
        System.out.println("@RestController —— list");
        return service.list();
    }

    @GetMapping("/redirect")
    public ModelAndView redirect() {
        return new ModelAndView("redirect:/login.html");
    }

    @GetMapping("/forward")
    public ModelAndView forward() {
        return new ModelAndView("forward:/WEB-INF/page/test.jsp");
    }

    // ...
}
