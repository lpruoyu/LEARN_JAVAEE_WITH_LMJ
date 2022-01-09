package programmer.lp.service.proxy;

import programmer.lp.service.SkillService;

public class SkillServiceProxy extends SkillService {

    private SkillService target;

    public SkillServiceProxy(SkillService target) {
        this.target = target;
    }

    @Override
    public void delete(Integer id) {
        System.out.println("日志/事务--------------start");
        target.delete(id);
        System.out.println("日志/事务--------------end");
    }

}
