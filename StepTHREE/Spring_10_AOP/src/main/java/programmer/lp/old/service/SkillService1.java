package programmer.lp.old.service;

import programmer.lp.annotation.Log;

public class SkillService1 {

    @Log
    public void delete(Integer id) {
        System.out.println("SkillService-核心业务-delete");
    }

}

