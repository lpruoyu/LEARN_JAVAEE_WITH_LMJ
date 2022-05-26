package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.controller.base.BaseController;
import programmer.lp.jk.pojo.po.ExamPlaceCourse;
import programmer.lp.jk.pojo.query.ExamPlaceCourseQuery;
import programmer.lp.jk.pojo.result.R;
import programmer.lp.jk.service.ExamPlaceCourseService;
import programmer.lp.jk.util.Rs;

@RestController
@RequestMapping("/examPlaceCourses")
public class ExamPlaceCourseController extends BaseController<ExamPlaceCourse> {
    @Autowired
    private ExamPlaceCourseService service;

    @GetMapping
    public R list(ExamPlaceCourseQuery query) {
        service.list(query);
        return Rs.success(query).add(Rs.K_COUNT, query.getTotal());
    }

    @Override
    protected IService<ExamPlaceCourse> service() {
        return service;
    }
}

