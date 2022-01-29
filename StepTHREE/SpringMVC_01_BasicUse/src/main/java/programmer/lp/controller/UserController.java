package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @GetMapping({"/addUser", "/insertUser"})
    @ResponseBody
    public String addUser() {
        return "Add Success!";
    }

    @PostMapping({"/removeUser", "/deleteUser"})
    @ResponseBody
    public String removeUser() {
        return "Remove Success!";
    }

    @RequestMapping(value = {"/getUser", "/fetchUser"}, method = RequestMethod.GET)
    @ResponseBody
    public String getUser() {
        return "Get success!";
    }

}
