package programmer.lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.domain.JdbcProperties;

@RestController
public class TestController {
    @Autowired
    private JdbcProperties jdbcProperties;

    @GetMapping("/test")
    public String test() {
        return jdbcProperties.toString();
    }
}
