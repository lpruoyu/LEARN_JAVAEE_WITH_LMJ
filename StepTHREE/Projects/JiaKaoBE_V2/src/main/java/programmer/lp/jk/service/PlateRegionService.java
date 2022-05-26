package programmer.lp.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.dto.ProvinceDto;
import programmer.lp.jk.pojo.po.PlateRegion;
import programmer.lp.jk.pojo.query.CityQuery;
import programmer.lp.jk.pojo.query.ProvinceQuery;

import java.util.List;

public interface PlateRegionService extends IService<PlateRegion> {
    void listProvinces(ProvinceQuery query);
    void listCities(CityQuery query);
    List<PlateRegion> listProvinces();
    List<ProvinceDto> listRegions();
}