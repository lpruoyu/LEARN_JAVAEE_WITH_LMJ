package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginInterceptorController {

    @GetMapping("/login")
    public ModelAndView login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        final ModelAndView modelAndView = new ModelAndView();
        if (username.equals("admin") && password.equals("123")) {
            request.getSession().setAttribute("user", username);
            modelAndView.setViewName("success.jsp");
        } else {
            modelAndView.addObject("error", "账号或密码有误！！");
            modelAndView.setViewName("login.jsp");
        }
        return modelAndView;
    }

}
