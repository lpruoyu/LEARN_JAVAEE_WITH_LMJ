package programmer.lp.controller;

import org.springframework.web.bind.annotation.*;

//@Controller
public class UserController4 {
    // @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    // 等价于
    @GetMapping({"/addUser", "/insertUser"})
    @ResponseBody
    public String addUser() {
        return "Add Success!";
    }

    // @RequestMapping(value = "/removeUser", method = RequestMethod.POST)
    // 等价于
    @PostMapping({"/removeUser", "/deleteUser"})
    @ResponseBody
    public String removeUser() {
        return "Remove Success!";
    }

    @RequestMapping(value = {"/getUser", "/fetchUser"}, method = RequestMethod.GET)
    public String getUser() {
        return "Get success!";
    }

}
