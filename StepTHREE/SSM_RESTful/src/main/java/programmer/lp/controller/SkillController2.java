package programmer.lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import programmer.lp.domain.Skill;
import programmer.lp.service.SkillService;

import java.util.List;

//@Controller
@ResponseBody
@RequestMapping("/skills")
public class SkillController2 {
    @Autowired
    private SkillService service;

    @GetMapping("/{id}")
    public Skill get(@PathVariable("id") Integer id) {
        return service.get(id);
    }

    @GetMapping
    public List<Skill> list() {
        return service.list();
    }

    // ...
}
