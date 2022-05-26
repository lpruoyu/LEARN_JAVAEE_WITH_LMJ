package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.controller.base.BaseController;
import programmer.lp.jk.pojo.po.DictType;
import programmer.lp.jk.pojo.query.DictTypeQuery;
import programmer.lp.jk.pojo.result.R;
import programmer.lp.jk.service.DictTypeService;
import programmer.lp.jk.util.Rs;

@RestController
@RequestMapping("/dictTypes")
public class DictTypeController extends BaseController<DictType> {
    @Autowired
    private DictTypeService service;

    @GetMapping
    public R list(DictTypeQuery query) {
        service.list(query);
        return Rs.success(query).add(Rs.K_COUNT, query.getTotal());
    }

    @Override
    protected IService<DictType> service() {
        return service;
    }
}

