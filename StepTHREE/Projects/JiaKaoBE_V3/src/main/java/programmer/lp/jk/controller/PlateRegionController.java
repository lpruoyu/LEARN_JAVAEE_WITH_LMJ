package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.controller.base.BaseController;
import programmer.lp.jk.mapstruct.MapStruct;
import programmer.lp.jk.pojo.dto.ProvinceDto;
import programmer.lp.jk.pojo.po.PlateRegion;
import programmer.lp.jk.pojo.vo.req.page.ReqPageCity;
import programmer.lp.jk.pojo.vo.req.page.ReqPageProvince;
import programmer.lp.jk.pojo.vo.req.save.ReqSavePlateRegion;
import programmer.lp.jk.pojo.vo.resp.RespPlateRegion;
import programmer.lp.jk.pojo.vo.resp.json.JSONDataResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.service.PlateRegionService;

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
    public JSONPageResult<RespPlateRegion> listProvinces(ReqPageProvince reqPageProvince) {
        return service.listProvinces(reqPageProvince);
    }

    @GetMapping("/cities")
    @ApiOperation("分页查询城市信息")
    public JSONPageResult<RespPlateRegion> listCities(ReqPageCity reqPageCity) {
        return service.listCities(reqPageCity);
    }

    @GetMapping("/provinces/list")
    @ApiOperation("查询所有的省份信息")
    public JSONDataResult<List<RespPlateRegion>> listProvinces() {
        return service.listProvinces();
    }

    @GetMapping("/regions")
    @ApiOperation("查询所有的区域信息（省份+城市）")
    public JSONDataResult<List<ProvinceDto>> listRegions() {
        return service.listRegions();
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

