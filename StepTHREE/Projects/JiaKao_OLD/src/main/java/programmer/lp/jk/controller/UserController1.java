package programmer.lp.jk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import programmer.lp.jk.pojo.other.User;

import java.util.ArrayList;
import java.util.List;

//@RestController
//@CrossOrigin("*") // 所有的源都可以跨域访问该Controller下的请求
//@CrossOrigin({"http://localhost:63343","http://192.168.152.130:8888"})
//@CrossOrigin("http://localhost:63343")
public class UserController1 {

    @GetMapping("/users")
//    @CrossOrigin("http://localhost:63343")
    public List<User> user() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new User("lp" + i, i));
        }
        return list;
    }

}
