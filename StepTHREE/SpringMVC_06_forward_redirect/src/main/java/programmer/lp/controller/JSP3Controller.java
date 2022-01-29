package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JSP3Controller {

    @GetMapping("/path1/path2/path3")
    public ModelAndView jsp3() {
        return new ModelAndView("/path1/path2/page/test.jsp");
//        return new ModelAndView("page/test.jsp");
    }

}
