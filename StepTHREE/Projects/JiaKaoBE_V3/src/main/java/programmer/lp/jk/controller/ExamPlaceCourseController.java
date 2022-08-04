package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.common.enhance.CodeMsg;
import programmer.lp.jk.common.mapstruct.MapStruct;
import programmer.lp.jk.common.util.Constants;
import programmer.lp.jk.common.util.JSONResults;
import programmer.lp.jk.pojo.po.ExamPlaceCourse;
import programmer.lp.jk.pojo.vo.req.page.ReqPageExamPlaceCourse;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveExamPlaceCourse;
import programmer.lp.jk.pojo.vo.resp.RespExamPlaceCourse;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONResult;
import programmer.lp.jk.service.ExamPlaceCourseService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/examPlaceCourses")
@Api(tags = "课程（科二科三）", description = "ExamPlaceCourse")
public class ExamPlaceCourseController extends BaseController<ExamPlaceCourse, ReqSaveExamPlaceCourse> {
    @Autowired
    private ExamPlaceCourseService service;

    @GetMapping
    @ApiOperation("分页查询")
    @RequiresPermissions(Constants.Permisson.EXAM_PLACE_COURSE_LIST)
    public JSONPageResult<RespExamPlaceCourse> list(@Valid ReqPageExamPlaceCourse query) {
        return service.list(query);
    }

    @Override
    @RequiresPermissions(value = {
            Constants.Permisson.EXAM_PLACE_COURSE_ADD,
            Constants.Permisson.EXAM_PLACE_COURSE_UPDATE
    }, logical = Logical.AND)
    public JSONResult save(ReqSaveExamPlaceCourse entity) {
        if (service.saveOrUpdate(entity)) {
            return JSONResults.ok(CodeMsg.SAVE_OK);
        } else {
            return JSONResults.exception(CodeMsg.SAVE_ERROR);
        }
    }

    @Override
    @RequiresPermissions(Constants.Permisson.EXAM_PLACE_COURSE_REMOVE)
    public JSONResult remove(String id) {
        List<String> idStrs = Arrays.asList(id.split(","));
        if (CollectionUtils.isEmpty(idStrs)) {
            return JSONResults.exception(CodeMsg.REMOVE_ERROR);
        }

        boolean ret = true;
        for (String idStr : idStrs) {
            if (!service.removeById(idStr)) {
                ret = false;
            }
        }

        return ret ? JSONResults.ok(CodeMsg.REMOVE_OK) : JSONResults.exception(CodeMsg.REMOVE_ERROR);
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

