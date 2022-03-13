package programmer.lp.controller;

import programmer.lp.dao.SkillDao;
import programmer.lp.service.SkillService;

public class SkillController {
    private SkillService service;

    public static void main(String[] args) {
        System.out.println(SkillService.class);
        System.out.println(SkillDao.class);
    }
}
