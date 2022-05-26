package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.jk.enhance.MPPage;
import programmer.lp.jk.enhance.MPQueryWrapper;
import programmer.lp.jk.mapper.ExamPlaceCourseMapper;
import programmer.lp.jk.pojo.po.ExamPlaceCourse;
import programmer.lp.jk.pojo.query.ExamPlaceCourseQuery;
import programmer.lp.jk.service.ExamPlaceCourseService;

@Transactional
@Service
public class ExamPlaceCourseServiceImpl extends ServiceImpl<ExamPlaceCourseMapper, ExamPlaceCourse> implements ExamPlaceCourseService {
    @Override
    public void list(ExamPlaceCourseQuery query) {
        baseMapper.selectPage(new MPPage<>(query), new MPQueryWrapper<>());
    }
}