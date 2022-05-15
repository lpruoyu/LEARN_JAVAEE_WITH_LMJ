package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.controller.base.BaseController;
import programmer.lp.jk.pojo.po.Province;
import programmer.lp.jk.pojo.query.ProvinceQuery;
import programmer.lp.jk.pojo.result.R;
import programmer.lp.jk.service.ProvinceService;
import programmer.lp.jk.util.Rs;

@RestController
@RequestMapping("/provinces")
public class ProvinceController extends BaseController<Province> {
    @Autowired
    private ProvinceService service;

    @GetMapping("/list")
    public R list(ProvinceQuery query) {
        service.list(query);
        return Rs.success(query).add(Rs.K_COUNT, query.getTotal());
    }

    @Override
    protected IService<Province> service() {
        return service;
    }
}

