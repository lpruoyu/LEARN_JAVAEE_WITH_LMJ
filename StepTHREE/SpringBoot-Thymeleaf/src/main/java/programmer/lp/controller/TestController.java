package programmer.lp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "SB";
    }

    @GetMapping("/indexMV")
    public ModelAndView index() {
        final ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name", "lpruoyu");
        modelAndView.addObject("age", 22);
        return modelAndView;
    }
}
