package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JSON1Controller {
    /*
格式化前（利于传输，不浪费空间）：
{"name":"Jack","age":20,"car":{"name":"Audi","price":100}}
格式化后（好看，不利于传输，浪费空间）：
{
  "name": "Jack",
  "age": 20,
  "car": {
    "name": "Audi",
    "price": 100
  }
}
     */
    @GetMapping(value = "/json1", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json1() {
        return "{\"name\":\"Jack\",\"age\":20,\"car\":{\"name\":\"Audi\",\"price\":100}}";
    }
}

