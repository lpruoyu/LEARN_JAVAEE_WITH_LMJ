package programmer.lp.jk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import programmer.lp.jk.pojo.query.DictItemQuery;
import programmer.lp.jk.service.DictItemService;

@Controller
@RequestMapping("/dictItems")
public class DictItemController {
    @Autowired
    private DictItemService service;

    @GetMapping("/list")
    public String list(DictItemQuery query, Model model) {
        service.list(query);
        model.addAttribute("query", query);
        return "pages/dictItem";
    }
}
