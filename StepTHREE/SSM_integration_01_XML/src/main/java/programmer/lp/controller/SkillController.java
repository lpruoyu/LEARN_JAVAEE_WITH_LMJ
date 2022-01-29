package programmer.lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import programmer.lp.domain.Skill;
import programmer.lp.service.SkillService;

import java.util.List;

/*
    规定：
        读：使用GET请求
        写：使用POST请求
*/

@Controller
@RequestMapping("/skill")
public class SkillController {

    private SkillService service;

    @Autowired
    public void setService(SkillService service) {
        this.service = service;
    }

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
