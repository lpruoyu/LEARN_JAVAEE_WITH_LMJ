package programmer.lp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import programmer.lp.domain.Dog;

@Controller
public class JSP2Controller {
    @Value("${jsp-dog-localpath}")
    private String dogLocalpath;

    @GetMapping("${jsp-dog-url}")
    public ModelAndView jsp2() {
        ModelAndView mv = new ModelAndView();
        // 使用MyBatis从数据库中获取数据
        Dog dog = new Dog();
        dog.setName("Larry");
        dog.setAge(8);
        // 本质就是request.setAttribute
        mv.addObject("dog", dog);
        // 设置需要转发的页面
        mv.setViewName(dogLocalpath);
        return mv;
    }




//    写法一
//    ModelAndView mv = new ModelAndView();
//        mv.setViewName(dogLocalpath);
//    写法二
//    ModelAndView mv = new ModelAndView(dogLocalpath);

}
