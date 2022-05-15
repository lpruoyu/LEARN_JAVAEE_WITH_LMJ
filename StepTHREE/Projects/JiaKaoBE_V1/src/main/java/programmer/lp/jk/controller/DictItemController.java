package programmer.lp.jk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.service.DictItemService;

@RestController
@RequestMapping("/dictItems")
public class DictItemController {
    @Autowired
    private DictItemService service;
    
}

