package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/IRVR2")
public class JspController2 {
    @GetMapping("/forward")
    public ModelAndView forward() {
        ModelAndView mv = new ModelAndView();
        mv.setView(new InternalResourceView("/WEB-INF/page/jsp/jsp1.jsp"));
        return mv;
    }

    @GetMapping("/redirect")
    public ModelAndView redirect(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new RedirectView(request.getContextPath() + "/public/jsp6.jsp"));
        return mv;
    }

}
