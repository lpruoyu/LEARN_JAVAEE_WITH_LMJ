package programmer.lp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//@RequestMapping("/skill")
//@Controller
public class SkillController1 {

    @PostMapping("/add")
    @ResponseBody
    public String add(
            HttpServletRequest request
//            HttpServletResponse response,
//            HttpSession session,
//            WebRequest webRequest
    ) {
        System.out.println("request : " + request);
//        System.out.println("response : " + response);
//        System.out.println("session : " + session);
//        System.out.println("webRequest : " + webRequest);
        return "Add Success!";
    }

}
