package programmer.lp.jk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import programmer.lp.jk.pojo.query.DictTypeQuery;
import programmer.lp.jk.service.DictTypeService;

@Controller
@RequestMapping("/dictTypes")
public class DictTypeController {
    @Autowired
    private DictTypeService service;

    @GetMapping("/list")
    public String list(DictTypeQuery query, Model model) {
        service.list(query);
        model.addAttribute("query", query);
        return "pages/dictType";
    }

//    @GetMapping("/list")
//    public String list(Model model) {
//        final List<DictType> list = service.list();
//        model.addAttribute("data", list);
//        return "pages/dictType";
//    }
}
