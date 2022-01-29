package programmer.lp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class UserController1 {
    @RequestMapping(value = "/addUser")
    @ResponseBody
    public String addUser() {
        return "Add Success!";
    }

    @RequestMapping(value = "/removeUser")
    @ResponseBody
    public String removeUser() {
        return "Remove Success!";
    }
}
