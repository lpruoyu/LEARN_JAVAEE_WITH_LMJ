package programmer.lp.jk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.common.filter.ErrorFilter;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorController {
    @RequestMapping(ErrorFilter.ERROR_URI)
    public void handle(HttpServletRequest request) throws Exception {
        // 抛出异常
        throw (Exception) request.getAttribute(ErrorFilter.ERROR_URI);
    }
}