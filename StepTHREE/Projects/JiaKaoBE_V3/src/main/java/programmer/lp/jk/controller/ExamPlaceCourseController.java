package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.controller.base.BaseController;
import programmer.lp.jk.mapstruct.MapStruct;
import programmer.lp.jk.pojo.po.ExamPlaceCourse;
import programmer.lp.jk.pojo.vo.req.page.ReqPageExamPlaceCourse;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveExamPlaceCourse;
import programmer.lp.jk.pojo.vo.resp.RespExamPlaceCourse;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.service.ExamPlaceCourseService;

import java.util.function.Function;

@RestController
@RequestMapping("/examPlaceCourses")
@Api(tags = "科二科三课程", description = "ExamPlaceCourse")
public class ExamPlaceCourseController extends BaseController<ExamPlaceCourse, ReqSaveExamPlaceCourse> {
    @Autowired
    private ExamPlaceCourseService service;

    @GetMapping
    @ApiOperation("分页查询")
    public JSONPageResult<RespExamPlaceCourse> list(ReqPageExamPlaceCourse query) {
        return service.list(query);
    }

    @Override
    protected IService<ExamPlaceCourse> service() {
        return service;
    }

    @Override
    protected Function<ReqSaveExamPlaceCourse, ExamPlaceCourse> function() {
        return MapStruct.INSTANCE::vo2po;
    }
}

