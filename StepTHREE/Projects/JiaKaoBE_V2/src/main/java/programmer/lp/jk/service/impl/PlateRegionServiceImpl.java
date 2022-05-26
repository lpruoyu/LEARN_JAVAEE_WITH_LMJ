package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.promeg.pinyinhelper.Pinyin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import programmer.lp.jk.enhance.MPPage;
import programmer.lp.jk.enhance.MPQueryWrapper;
import programmer.lp.jk.mapper.PlateRegionMapper;
import programmer.lp.jk.pojo.dto.ProvinceDto;
import programmer.lp.jk.pojo.po.PlateRegion;
import programmer.lp.jk.pojo.query.CityQuery;
import programmer.lp.jk.pojo.query.ProvinceQuery;
import programmer.lp.jk.service.PlateRegionService;

import java.util.List;

@Transactional
@Service
public class PlateRegionServiceImpl extends ServiceImpl<PlateRegionMapper, PlateRegion> implements PlateRegionService {
    // IService.saveOrUpdate方法里面会调用updateById或者save方法，因此需要重写这两个方法对拼音进行处理
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
    public void listProvinces(ProvinceQuery query) {
        MPQueryWrapper<PlateRegion> wrapper = new MPQueryWrapper<>();
        wrapper.like(query.getKeyword(), PlateRegion::getPlate, PlateRegion::getName, PlateRegion::getPinyin);
        // parentId为0代表这条记录为省份
        wrapper.eq(PlateRegion::getParentId, 0);
        wrapper.orderByAsc(PlateRegion::getPinyin);
        baseMapper.selectPage(new MPPage<>(query), wrapper);
    }

    @Override
    @Transactional(readOnly = true)
    public void listCities(CityQuery query) {
        MPQueryWrapper<PlateRegion> wrapper = new MPQueryWrapper<>();
        wrapper.like(query.getKeyword(), PlateRegion::getPlate, PlateRegion::getName, PlateRegion::getPinyin);
        final Integer parentId = query.getParentId();
        if (parentId != null && parentId > 0) {
            // 如果客户传了parentId，那就按照parentId查
            wrapper.eq(PlateRegion::getParentId, parentId);
        } else {
            // 查询所有的城市（parentId不为0就代表是城市）
            wrapper.ne(PlateRegion::getParentId, 0);
        }
        wrapper.orderByAsc(PlateRegion::getPlate);
        baseMapper.selectPage(new MPPage<>(query), wrapper);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlateRegion> listProvinces() {
        MPQueryWrapper<PlateRegion> wrapper = new MPQueryWrapper<>();
        wrapper.eq(PlateRegion::getParentId, 0);
        wrapper.orderByAsc(PlateRegion::getPinyin);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<ProvinceDto> listRegions() {
        return baseMapper.selectRegions();
    }
}