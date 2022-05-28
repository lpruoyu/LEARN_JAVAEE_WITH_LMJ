package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.jk.enhance.MPPage;
import programmer.lp.jk.enhance.MPQueryWrapper;
import programmer.lp.jk.mapper.ExamPlaceCourseMapper;
import programmer.lp.jk.mapstruct.MapStruct;
import programmer.lp.jk.pojo.po.ExamPlaceCourse;
import programmer.lp.jk.pojo.vo.req.page.ReqPageExamPlaceCourse;
import programmer.lp.jk.pojo.vo.resp.RespExamPlaceCourse;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.service.ExamPlaceCourseService;

@Transactional
@Service
public class ExamPlaceCourseServiceImpl extends ServiceImpl<ExamPlaceCourseMapper, ExamPlaceCourse> implements ExamPlaceCourseService {
    @Override
    public JSONPageResult<RespExamPlaceCourse> list(ReqPageExamPlaceCourse reqPage) {
        return baseMapper.selectPage(new MPPage<ExamPlaceCourse, RespExamPlaceCourse>(reqPage), new MPQueryWrapper<>()).buildResult(MapStruct.INSTANCE::po2vo);
    }
}