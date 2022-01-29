package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/test3")
public class TestController3 {
    @GetMapping("/demo3")
    @ResponseBody
    public String demo3(@RequestParam Map<String, Object> map,
                       @RequestParam Set<String> hobby) {
        System.out.println("Set<String>");
        System.out.println("name: " + map.get("name"));
        System.out.println("age: " + map.get("age"));
        System.out.print("hobby: ");
        for (String h : hobby) {
            System.out.print(h + " ");
        }
        System.out.println();
        return "success!";
    }

    @GetMapping("/demo2")
    @ResponseBody
    public String demo2(@RequestParam Map<String, Object> map,
                        @RequestParam String[] hobby) {
        System.out.println("String[]");
        System.out.println("name: " + map.get("name"));
        System.out.println("age: " + map.get("age"));
        System.out.print("hobby: ");
        for (String h : hobby) {
            System.out.print(h + " ");
        }
        System.out.println();
        return "success!";
    }

    @GetMapping("/demo1")
    @ResponseBody
    public String demo1(@RequestParam Map<String, Object> map,
                        @RequestParam List<String> hobby) {
        System.out.println("List<String>");
        System.out.println("name: " + map.get("name"));
        System.out.println("age: " + map.get("age"));
        System.out.print("hobby: ");
        for (String h : hobby) {
            System.out.print(h + " ");
        }
        System.out.println();
        return "success!";
    }
}
