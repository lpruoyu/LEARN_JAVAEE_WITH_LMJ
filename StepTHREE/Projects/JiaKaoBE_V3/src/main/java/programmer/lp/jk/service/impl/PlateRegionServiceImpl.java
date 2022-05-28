package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.promeg.pinyinhelper.Pinyin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import programmer.lp.jk.enhance.MPPage;
import programmer.lp.jk.enhance.MPQueryWrapper;
import programmer.lp.jk.mapper.PlateRegionMapper;
import programmer.lp.jk.mapstruct.MapStruct;
import programmer.lp.jk.pojo.dto.ProvinceDto;
import programmer.lp.jk.pojo.po.PlateRegion;
import programmer.lp.jk.pojo.vo.req.page.ReqPageCity;
import programmer.lp.jk.pojo.vo.req.page.ReqPageProvince;
import programmer.lp.jk.pojo.vo.resp.RespPlateRegion;
import programmer.lp.jk.pojo.vo.resp.json.JSONDataResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.service.PlateRegionService;
import programmer.lp.jk.util.JSONResults;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class PlateRegionServiceImpl extends ServiceImpl<PlateRegionMapper, PlateRegion> implements PlateRegionService {
    @Override
    public boolean updateById(PlateRegion entity) {
        processPinyin(entity);
        return super.updateById(entity);
    }

    @Override
    public boolean save(PlateRegion entity) {
        processPinyin(entity);
        return super.save(entity);
    }

    private void processPinyin(PlateRegion entity) {
        final String name = entity.getName();
        if (StringUtils.isEmpty(name)) return;
        entity.setPinyin(Pinyin.toPinyin(name, "_"));
    }

    @Override
    @Transactional(readOnly = true)
    public JSONPageResult<RespPlateRegion> listProvinces(ReqPageProvince reqPage) {
        MPQueryWrapper<PlateRegion> wrapper = new MPQueryWrapper<>();
        wrapper.like(reqPage.getKeyword(), PlateRegion::getPlate, PlateRegion::getName, PlateRegion::getPinyin);
        // parentId为0代表这条记录为省份
        wrapper.eq(PlateRegion::getParentId, 0);
        wrapper.orderByAsc(PlateRegion::getPinyin);
        return baseMapper.selectPage(new MPPage<PlateRegion, RespPlateRegion>(reqPage), wrapper).buildResult(MapStruct.INSTANCE::po2vo);
    }

    @Override
    @Transactional(readOnly = true)
    public JSONPageResult<RespPlateRegion> listCities(ReqPageCity reqPage) {
        MPQueryWrapper<PlateRegion> wrapper = new MPQueryWrapper<>();
        wrapper.like(reqPage.getKeyword(), PlateRegion::getPlate, PlateRegion::getName, PlateRegion::getPinyin);
        final Integer parentId = reqPage.getParentId();
        if (parentId != null && parentId > 0) {
            wrapper.eq(PlateRegion::getParentId, parentId);
        } else {
            wrapper.ne(PlateRegion::getParentId, 0);
        }
        wrapper.orderByAsc(PlateRegion::getPlate);
        return baseMapper.selectPage(new MPPage<PlateRegion, RespPlateRegion>(reqPage), wrapper).buildResult(MapStruct.INSTANCE::po2vo);
    }

    @Override
    @Transactional(readOnly = true)
    public JSONDataResult<List<RespPlateRegion>> listProvinces() {
        MPQueryWrapper<PlateRegion> wrapper = new MPQueryWrapper<>();
        wrapper.eq(PlateRegion::getParentId, 0);
        wrapper.orderByAsc(PlateRegion::getPinyin);
        final List<RespPlateRegion> data = baseMapper.selectList(wrapper)
                .stream().map(MapStruct.INSTANCE::po2vo)
                .collect(Collectors.toList());
        return JSONResults.success(data);
    }

    @Override
    public JSONDataResult<List<ProvinceDto>> listRegions() {
        return JSONResults.success(baseMapper.selectRegions());
    }
}
