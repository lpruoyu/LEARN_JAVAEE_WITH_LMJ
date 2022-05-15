package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.controller.base.BaseController;
import programmer.lp.jk.pojo.po.DictItem;
import programmer.lp.jk.pojo.query.DictItemQuery;
import programmer.lp.jk.pojo.result.R;
import programmer.lp.jk.service.DictItemService;
import programmer.lp.jk.util.Rs;

@RestController
@RequestMapping("/dictItems")
public class DictItemController extends BaseController<DictItem> {
    @Autowired
    private DictItemService service;

    @GetMapping("/list")
    public R list(DictItemQuery query) {
        service.list(query);
        return Rs.success(query).add(Rs.K_COUNT, query.getTotal());
    }

    @Override
    protected IService<DictItem> service() {
        return service;
    }
}

