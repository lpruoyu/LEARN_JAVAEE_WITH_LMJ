package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        request.setAttribute("name", "lhh");
        request.setAttribute("age", 18);
        request.setAttribute("msg", "<div>message</div>");
        return "index";
    }


    @GetMapping("/indexModel")
    public String indexModel(Model model) {
        model.addAttribute("name", "liuhaha");
        model.addAttribute("age", 10);
        return "index";
    }

    @GetMapping("/index2")
    public String index2() {
        return "index";
    }
}
