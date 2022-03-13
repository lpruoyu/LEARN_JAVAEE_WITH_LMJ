package programmer.lp.controller_old;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/users")
    @ResponseBody
    public String getUsers() {
        return "get /users";
    }

    @PostMapping("/users")
    @ResponseBody
    public String postUsers() {
        return "post /users";
    }

}
