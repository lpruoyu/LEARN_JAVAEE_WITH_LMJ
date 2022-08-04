package programmer.lp.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.po.ExamPlaceCourse;
import programmer.lp.jk.pojo.vo.req.page.ReqPageExamPlaceCourse;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveExamPlaceCourse;
import programmer.lp.jk.pojo.vo.resp.RespExamPlaceCourse;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;

public interface ExamPlaceCourseService extends IService<ExamPlaceCourse> {
    JSONPageResult<RespExamPlaceCourse> list(ReqPageExamPlaceCourse reqPage);
    boolean saveOrUpdate(ReqSaveExamPlaceCourse entity);
}
