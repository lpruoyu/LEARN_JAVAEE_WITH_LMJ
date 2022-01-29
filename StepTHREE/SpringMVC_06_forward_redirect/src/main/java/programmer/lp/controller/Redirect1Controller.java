package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Redirect1Controller {
    @GetMapping("/redirect1")
    public void redirect1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}
