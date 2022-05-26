package programmer.lp.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.po.ExamPlaceCourse;
import programmer.lp.jk.pojo.query.ExamPlaceCourseQuery;

public interface ExamPlaceCourseService extends IService<ExamPlaceCourse> {
    void list(ExamPlaceCourseQuery query);
}
