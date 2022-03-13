package programmer.lp.controller_old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import programmer.lp.domain.Skill;
import programmer.lp.service.SkillService;

import java.util.List;

//@Controller
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    private SkillService service;

    @PostMapping("/remove")
    @ResponseBody
    public String remove(Integer id) {
        return service.remove(id) ? "删除成功" : "删除失败";
    }

    @PostMapping("/save")
    @ResponseBody
    public String save(Skill skill) {
        return service.save(skill) ? "保存成功" : "保存失败";
    }

    @GetMapping("/get")
    @ResponseBody
    public Skill get(Integer id) {
        return service.get(id);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Skill> list() {
        return service.list();
    }
}
