package programmer.lp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {
    @Value("${plain}")
    private String plain;
    @Value("${names}")
    private String[] names;
//    List、Set和数组一样
//    private List<String> names;
//    private Set<String> names;

    @Value("#{${scores}}")
    private Map<String, Integer> scores;
    @Value("#{${homes}}")
    private Map<String, String> homes;

    @GetMapping("/test")
    public String test() {
        for (String name : names) {
            System.out.println(name);
        }
        scores.forEach((k, v) -> {
            System.out.println(k + "_" + v);
        });
        homes.forEach((k, v) -> {
            System.out.println(k + "_" + v);
        });
        return "running success!";
    }
}
