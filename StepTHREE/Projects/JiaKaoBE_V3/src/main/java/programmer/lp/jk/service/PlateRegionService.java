package programmer.lp.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.po.PlateRegion;
import programmer.lp.jk.pojo.vo.req.page.ReqPageCity;
import programmer.lp.jk.pojo.vo.req.page.ReqPageProvince;
import programmer.lp.jk.pojo.vo.resp.RespPlateRegion;
import programmer.lp.jk.pojo.vo.resp.RespProvince;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;

import java.util.List;

public interface PlateRegionService extends IService<PlateRegion> {
    JSONPageResult<RespPlateRegion> listProvinces(ReqPageProvince reqPage);
    JSONPageResult<RespPlateRegion> listCities(ReqPageCity reqPage);
    List<RespPlateRegion> listProvinces();
    List<RespProvince> listRegions();
}