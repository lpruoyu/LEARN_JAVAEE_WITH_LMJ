package programmer.lp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class UserController2 {
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    @ResponseBody
    public String addUser() {
        return "Add Success!";
    }

    @RequestMapping(value = "/removeUser", method = RequestMethod.POST)
    @ResponseBody
    public String removeUser() {
        return "Remove Success!";
    }
}
