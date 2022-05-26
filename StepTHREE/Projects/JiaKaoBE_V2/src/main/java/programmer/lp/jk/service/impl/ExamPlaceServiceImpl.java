package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.jk.enhance.MPPage;
import programmer.lp.jk.enhance.MPQueryWrapper;
import programmer.lp.jk.mapper.ExamPlaceMapper;
import programmer.lp.jk.pojo.dto.ProvinceDto;
import programmer.lp.jk.pojo.po.ExamPlace;
import programmer.lp.jk.pojo.query.ExamPlaceQuery;
import programmer.lp.jk.service.ExamPlaceService;

import java.util.List;

@Transactional
@Service
public class ExamPlaceServiceImpl extends ServiceImpl<ExamPlaceMapper, ExamPlace> implements ExamPlaceService {
    @Override
    @Transactional(readOnly = true)
    public void list(ExamPlaceQuery query) {
        final MPQueryWrapper<ExamPlace> wrapper = new MPQueryWrapper<>();
        wrapper.like(query.getKeyword(), ExamPlace::getName, ExamPlace::getAddress);
        // 有城市必有省份
        // 有省份不一定有城市
        final Integer cityId = query.getCityId();
        final Integer provinceId = query.getProvinceId();
        if (cityId != null && cityId > 0) {
            wrapper.eq(ExamPlace::getCityId, cityId);
        } else if (provinceId != null && provinceId > 0) {
            wrapper.eq(ExamPlace::getProvinceId, provinceId);
        }
        baseMapper.selectPage(new MPPage<>(query), wrapper);
    }

    @Override
    public List<ProvinceDto> listRegionExamPlaces() {
        return baseMapper.selectRegionExamPlaces();
    }
}

