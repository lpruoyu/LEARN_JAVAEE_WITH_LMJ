package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.jk.enhance.MPPage;
import programmer.lp.jk.enhance.MPQueryWrapper;
import programmer.lp.jk.mapper.ExamPlaceMapper;
import programmer.lp.jk.mapstruct.MapStruct;
import programmer.lp.jk.pojo.dto.ProvinceDto;
import programmer.lp.jk.pojo.po.ExamPlace;
import programmer.lp.jk.pojo.vo.req.page.ReqPageExamPlace;
import programmer.lp.jk.pojo.vo.resp.RespExamPlace;
import programmer.lp.jk.pojo.vo.resp.json.JSONDataResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.service.ExamPlaceService;
import programmer.lp.jk.util.JSONResults;

import java.util.List;

@Transactional
@Service
public class ExamPlaceServiceImpl extends ServiceImpl<ExamPlaceMapper, ExamPlace> implements ExamPlaceService {
    @Override
    @Transactional(readOnly = true)
    public JSONPageResult<RespExamPlace> list(ReqPageExamPlace reqPage) {
        final MPQueryWrapper<ExamPlace> wrapper = new MPQueryWrapper<>();
        wrapper.like(reqPage.getKeyword(), ExamPlace::getName, ExamPlace::getAddress);
        // 有城市必有省份
        // 有省份不一定有城市
        final Integer cityId = reqPage.getCityId();
        final Integer provinceId = reqPage.getProvinceId();
        if (cityId != null && cityId > 0) {
            wrapper.eq(ExamPlace::getCityId, cityId);
        } else if (provinceId != null && provinceId > 0) {
            wrapper.eq(ExamPlace::getProvinceId, provinceId);
        }
        return baseMapper.selectPage(new MPPage<ExamPlace, RespExamPlace>(reqPage), wrapper).buildResult(MapStruct.INSTANCE::po2vo);
    }

    @Override
    public JSONDataResult<List<ProvinceDto>> listRegionExamPlaces() {
        return JSONResults.success(baseMapper.selectRegionExamPlaces());
    }
}

