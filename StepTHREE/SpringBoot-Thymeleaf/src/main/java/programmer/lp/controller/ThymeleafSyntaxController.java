package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import programmer.lp.domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;

@Controller
public class ThymeleafSyntaxController {

//    @GetMapping("/comment")
//    public String comment() {
//        return "comment";
//    }

    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("name", "lpruoyu");
        model.addAttribute("age", 22);
        return "literal";
    }

    @GetMapping("/tri-operator")
    public String triOperator(Model model) {
//        model.addAttribute("age", 20);
//        model.addAttribute("name", "lp");
        return "tri-operator";
    }

    @GetMapping("/local-variable")
    public String localVariable(Model model) {
        model.addAttribute("age", 20);
        return "local-variable";
    }

    @GetMapping("/selected-var-expression")
    public String selectedVarExpression(Model model) {
        model.addAttribute("person", new Person("lp", 22));
        return "selected-var-expression";
    }

//    @GetMapping("/i18n")
//    public String i18n(Model model) {
//        return "i18n";
//    }

    @GetMapping("/link-expression")
    public String linkExpression(Model model) {
        model.addAttribute("age", 30);
        return "link-expression";
    }

    @GetMapping("/for")
    public String forX(Model model) {
        model.addAttribute("persons", Arrays.asList(
                new Person("lp", 10),
                new Person("ruoyu", 20),
                new Person("lpruoyu", 30),
                new Person("lpXruoyuX", 40)
        ));
        return "for";
    }

    @GetMapping("/block")
    public String block(Model model) {
        model.addAttribute("persons", Arrays.asList(
                new Person("lp", 10),
                new Person("ruoyu", 20),
                new Person("lpruoyu", 30),
                new Person("lpXruoyuX", 40)
        ));
        return "block";
    }

    @GetMapping("/attr")
    public String attr(Model model) {
        model.addAttribute("id", 23);
        return "attr";
    }

    @GetMapping("/inherent-object")
    public String inherentObject(HttpServletRequest request, HttpSession session) {
        request.setAttribute("date", new Date());
        request.setAttribute("name", "lp-request");
        session.setAttribute("name", "lp-session");
        request.getServletContext().setAttribute("name", "lp-context");
        return "inherent-object";
    }

}
