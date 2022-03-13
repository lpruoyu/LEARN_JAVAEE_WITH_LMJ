package programmer.lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import programmer.lp.domain.Skill;
import programmer.lp.service.SkillService;

import java.util.List;

@Controller
@RequestMapping("/skills")
public class SkillController {
    @Autowired
    private SkillService service;

    @PostMapping
    @ResponseBody
    public String insert(Skill skill) {
        System.out.println("post——post : " + skill);
        return service.insert(skill) ? "添加成功" : "添加失败";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String remove(@PathVariable("id") Integer id) {
        System.out.println("delete——remove____" + id);
        return service.remove(id) ? "删除成功" : "删除失败";
    }

    @PutMapping("/{id}")
    @ResponseBody
    public String update(Skill skill) {
        System.out.println("put——update____" + skill);
        return service.update(skill) ? "更新成功" : "更新失败";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Skill get(@PathVariable("id") Integer id) {
        return service.get(id);
    }

    @GetMapping
    @ResponseBody
    public List<Skill> list() {
        return service.list();
    }

//    @GetMapping("")
//    @ResponseBody
//    public List<Skill> list() {
//        return service.list();
//    }

//    @GetMapping("/")
//    @ResponseBody
//    public List<Skill> list() {
//        return service.list();
//    }
}
