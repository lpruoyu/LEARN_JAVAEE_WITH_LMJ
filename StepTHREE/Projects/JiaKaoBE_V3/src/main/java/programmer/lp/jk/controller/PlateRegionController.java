package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.common.mapstruct.MapStruct;
import programmer.lp.jk.common.util.Constants;
import programmer.lp.jk.common.util.JSONResults;
import programmer.lp.jk.pojo.vo.resp.RespProvince;
import programmer.lp.jk.pojo.po.PlateRegion;
import programmer.lp.jk.pojo.vo.req.page.ReqPageCity;
import programmer.lp.jk.pojo.vo.req.page.ReqPageProvince;
import programmer.lp.jk.pojo.vo.req.save.ReqSavePlateRegion;
import programmer.lp.jk.pojo.vo.resp.RespPlateRegion;
import programmer.lp.jk.pojo.vo.resp.json.JSONDataResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONResult;
import programmer.lp.jk.service.PlateRegionService;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/plateRegions")
@Api(tags = "区域（省份、城市）", description = "PlateRegion")
public class PlateRegionController extends BaseController<PlateRegion, ReqSavePlateRegion> {
    @Autowired
    private PlateRegionService service;

    @GetMapping("/provinces")
    @ApiOperation("分页查询省份信息")
    @RequiresPermissions(Constants.Permisson.PROVINCE_LIST)
    public JSONPageResult<RespPlateRegion> listProvinces(@Valid ReqPageProvince reqPageProvince) {
        return service.listProvinces(reqPageProvince);
    }

    @GetMapping("/cities")
    @ApiOperation("分页查询城市信息")
    @RequiresPermissions(Constants.Permisson.CITY_LIST)
    public JSONPageResult<RespPlateRegion> listCities(@Valid ReqPageCity reqPageCity) {
        return service.listCities(reqPageCity);
    }

    @GetMapping("/provinces/list")
    @ApiOperation("查询所有的省份信息")
    @RequiresPermissions(Constants.Permisson.PROVINCE_LIST)
    public JSONDataResult<List<RespPlateRegion>> listProvinces() {
        return JSONResults.ok(service.listProvinces());
    }

    @GetMapping("/regions")
    @ApiOperation("查询所有的区域信息（省份+城市）")
    @RequiresPermissions(value = {
            Constants.Permisson.PROVINCE_LIST,
            Constants.Permisson.CITY_LIST
    }, logical = Logical.AND)
    public JSONDataResult<List<RespProvince>> listRegions() {
        return JSONResults.ok(service.listRegions());
    }

    @Override
    @RequiresPermissions(value = {
            Constants.Permisson.PROVINCE_ADD,
            Constants.Permisson.PROVINCE_UPDATE,
            Constants.Permisson.CITY_ADD,
            Constants.Permisson.CITY_UPDATE,
    }, logical = Logical.AND)
    public JSONResult save(ReqSavePlateRegion entity) {
        return super.save(entity);
    }

    @Override
    @RequiresPermissions(value = {
            Constants.Permisson.PROVINCE_REMOVE,
            Constants.Permisson.CITY_REMOVE
    }, logical = Logical.AND)
    public JSONResult remove(String id) {
        return super.remove(id);
    }

    @Override
    protected IService<PlateRegion> service() {
        return service;
    }

    @Override
    protected Function<ReqSavePlateRegion, PlateRegion> function() {
        return MapStruct.INSTANCE::vo2po;
    }
}

