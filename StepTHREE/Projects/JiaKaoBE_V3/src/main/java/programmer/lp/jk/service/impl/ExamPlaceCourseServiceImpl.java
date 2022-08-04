package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.jk.common.enhance.CodeMsg;
import programmer.lp.jk.common.enhance.MPPage;
import programmer.lp.jk.common.enhance.MPQueryWrapper;
import programmer.lp.jk.common.mapstruct.MapStruct;
import programmer.lp.jk.common.util.JSONResults;
import programmer.lp.jk.common.util.Uploads;
import programmer.lp.jk.mapper.ExamPlaceCourseMapper;
import programmer.lp.jk.pojo.po.ExamPlaceCourse;
import programmer.lp.jk.pojo.vo.req.page.ReqPageExamPlaceCourse;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveExamPlaceCourse;
import programmer.lp.jk.pojo.vo.resp.RespExamPlaceCourse;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.service.ExamPlaceCourseService;

import java.io.Serializable;

@Transactional
@Service
public class ExamPlaceCourseServiceImpl extends ServiceImpl<ExamPlaceCourseMapper, ExamPlaceCourse> implements ExamPlaceCourseService {
    @Override
    @Transactional(readOnly = true)
    public JSONPageResult<RespExamPlaceCourse> list(ReqPageExamPlaceCourse reqPage) {
        final MPQueryWrapper<RespExamPlaceCourse> wrapper = new MPQueryWrapper<>();
        final Short type = reqPage.getType();
        final Integer cityId = reqPage.getCityId();
        final Integer provinceId = reqPage.getProvinceId();
        final Integer placeId = reqPage.getPlaceId();
        wrapper.like(reqPage.getKeyword(), "c.name", "intro");
        if (type != null) {
            wrapper.eq("c.type", type);
        }
        if (placeId != null && placeId > 0) {
            wrapper.eq("c.place_id", placeId);
        } else if (cityId != null && cityId > 0) {
            wrapper.eq("p.city_id", cityId);
        } else if (provinceId != null && provinceId > 0) {
            wrapper.eq("p.province_id", provinceId);
        }
        return baseMapper.selectPageResp(new MPPage<>(reqPage), wrapper)
                .buildResult();

        // SELECT COUNT(*) FROM exam_place_course c WHERE (province_id = ?)
        // SELECT COUNT(*) FROM exam_place_course c WHERE (city_id = ?)

//        MpQueryWrapper<ExamPlaceCourseVo> wrapper = new MpQueryWrapper<>();
//        Integer placeId = query.getPlaceId();
//        Integer provinceId = query.getProvinceId();
//        Integer cityId = query.getCityId();
//        Short type = query.getType();
//        // 类型
//        if (type != null && type >= 0) {
//            wrapper.eq(ExamPlaceCourseVo::getType, type);
//        }
//        // 考场 -> 城市 -> 省份
//        if (placeId != null && placeId > 0) {
//            wrapper.eq(ExamPlaceCourseVo::getPlaceId, placeId);
//        } else  if (cityId != null && cityId > 0) {
//            wrapper.eq(ExamPlaceCourseVo::getCityId, cityId);
//        } else if (provinceId != null && provinceId > 0) {
//            wrapper.eq(ExamPlaceCourseVo::getProvinceId, provinceId);
//        }
//        // 关键词
//        wrapper.like(query.getKeyword(), ExamPlaceCourseVo::getName, ExamPlaceCourseVo::getIntro);
//        return baseMapper
//                .selectPageVos(new MpPage<>(query), wrapper)
//                .buildVo();
        // 通过province_id查询时：Unknown column 'province_id' in 'where clause'
        // 通过province_id查询时：Unknown column 'city_id' in 'where clause'
        // 通过name查询时：Column 'name' in where clause is ambiguous
    }

    @Override
    public boolean saveOrUpdate(ReqSaveExamPlaceCourse entity) {
        try {
            ExamPlaceCourse po = MapStruct.INSTANCE.vo2po(entity);

            // 上传图片
            String filepath = Uploads.uploadImage(entity.getCoverFile());

            // 有新的图片上传成功
            if (filepath != null) {
                // 设置新的封面
                po.setCover(filepath);
            }

            // 保存po
            boolean ret = saveOrUpdate(po);
            if (ret && filepath != null) {
                // 删除旧封面
                Uploads.deleteFile(entity.getCover());
            }
            return ret;
        } catch (Exception e) {
            return JSONResults.exception(CodeMsg.UPLOAD_IMG_ERROR);
        }
    }

    @Override
    public boolean removeById(Serializable id) {
        ExamPlaceCourse course = getById(id);
        try {
            if (super.removeById(id)) {
                Uploads.deleteFile(course.getCover());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    @Override
//    @Transactional(readOnly = true)
//    public JSONPageResult<RespExamPlaceCourse> list(ReqPageExamPlaceCourse reqPage) {
//        final MPQueryWrapper<RespExamPlaceCourse> wrapper = new MPQueryWrapper<>();
//        final Short type = reqPage.getType();
//        final Integer cityId = reqPage.getCityId();
//        final Integer provinceId = reqPage.getProvinceId();
//        final Integer placeId = reqPage.getPlaceId();
//        wrapper.like(reqPage.getKeyword(), RespExamPlaceCourse::getName, RespExamPlaceCourse::getIntro);
//        if (type != null) {
//            wrapper.eq(RespExamPlaceCourse::getType, type);
//        }
//        if (placeId != null && placeId > 0) {
//            wrapper.eq(RespExamPlaceCourse::getPlaceId, placeId);
//        } else if (cityId != null && cityId > 0) {
//            wrapper.eq(RespExamPlaceCourse::getCityId, cityId);
//        } else if (provinceId != null && provinceId > 0) {
//            wrapper.eq(RespExamPlaceCourse::getProvinceId, provinceId);
//        }
//        return baseMapper.selectPageResp(new MPPage<>(reqPage), wrapper)
//                .buildResult();
//    }
}