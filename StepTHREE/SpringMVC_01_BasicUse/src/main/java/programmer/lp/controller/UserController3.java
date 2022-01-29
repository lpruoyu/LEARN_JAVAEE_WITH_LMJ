package programmer.lp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class UserController3 {
    // @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    // 等价于
    @GetMapping("/addUser")
    @ResponseBody
    public String addUser() {
        return "Add Success!";
    }

    // @RequestMapping(value = "/removeUser", method = RequestMethod.POST)
    // 等价于
    @PostMapping("/removeUser")
    @ResponseBody
    public String removeUser() {
        return "Remove Success!";
    }
}
