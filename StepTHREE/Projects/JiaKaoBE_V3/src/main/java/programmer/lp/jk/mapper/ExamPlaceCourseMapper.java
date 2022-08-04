package programmer.lp.jk.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import programmer.lp.jk.common.enhance.MPPage;
import programmer.lp.jk.pojo.po.ExamPlaceCourse;
import programmer.lp.jk.pojo.vo.resp.RespExamPlaceCourse;

public interface ExamPlaceCourseMapper extends BaseMapper<ExamPlaceCourse> {
    MPPage<RespExamPlaceCourse> selectPageResp(MPPage<RespExamPlaceCourse> page,
            /*@Param("ew")*/ @Param(Constants.WRAPPER) Wrapper<RespExamPlaceCourse> wrapper);
}
