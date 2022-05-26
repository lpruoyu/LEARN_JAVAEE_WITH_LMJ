package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.controller.base.BaseController;
import programmer.lp.jk.pojo.po.PlateRegion;
import programmer.lp.jk.pojo.query.CityQuery;
import programmer.lp.jk.pojo.query.ProvinceQuery;
import programmer.lp.jk.pojo.result.R;
import programmer.lp.jk.service.PlateRegionService;
import programmer.lp.jk.util.Rs;

@RestController
@RequestMapping("/plateRegions")
public class PlateRegionController extends BaseController<PlateRegion> {
    @Autowired
    private PlateRegionService service;

    @GetMapping("/provinces")
    public R listProvinces(ProvinceQuery query) {
        service.listProvinces(query);
        return Rs.success(query).add(Rs.K_COUNT, query.getTotal());
    }

    @GetMapping("/cities")
    public R listCities(CityQuery query) {
        service.listCities(query);
        return Rs.success(query).add(Rs.K_COUNT, query.getTotal());
    }

    @GetMapping("/provinces/list")
    public R listProvinces() {
        return Rs.success(service.listProvinces());
    }

    @GetMapping("/regions")
    public R listRegions() {
        return Rs.success(service.listRegions());
    }

    @Override
    protected IService<PlateRegion> service() {
        return service;
    }
}

